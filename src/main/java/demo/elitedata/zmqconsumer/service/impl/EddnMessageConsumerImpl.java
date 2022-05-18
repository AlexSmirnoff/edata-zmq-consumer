package demo.elitedata.zmqconsumer.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import demo.elitedata.zmqconsumer.client.DbAccessClient;
import demo.elitedata.zmqconsumer.enums.EddnSchema;
import demo.elitedata.zmqconsumer.mapper.EdMapper;
import demo.elitedata.zmqconsumer.model.zmq.commodities.CommoditiesMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.journal.JournalMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.journal.location.LocationMessageBody;
import demo.elitedata.zmqconsumer.service.EddnMessageConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EddnMessageConsumerImpl implements EddnMessageConsumer {
    private final ObjectMapper objectMapper;
    private final DbAccessClient dbAccessClient;
    private final EdMapper mapper;
    private final Map<String, String> unrecognizedMap = new HashMap<>();

    @Override
    public void consumeMessage(String message) {
        final var schema = EddnSchema.findSchemaByMessage(message);
        
        try {
            switch (schema) {
                case COMMODITIES: {
                    saveCommodities(message);
                    break;
                }
                case FSD_JUMP: case FSS_DISCOVERY_SCAN: case NAVBEACON_SCAN: {
                    saveSystem(message);
                    break;
                }
                case CARRIER_JUMP: {
                    break;
                }
                case LOCATION: {
                    saveStation(message);
                    break;
                }
                case DEFAULT: {
                    logUnrecognizedMessage(message);
                    break;
                }
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void saveCommodities(String commoditiesMessage) throws JsonProcessingException {
        var parsedMessage = objectMapper.readValue(getMessageBody(commoditiesMessage), CommoditiesMessageBody.class);
        dbAccessClient.postStation(mapper.toStation(parsedMessage));
    }

    private void saveStation(String stationMessage) throws JsonProcessingException {
        var parsedMessage = objectMapper.readValue(getMessageBody(stationMessage), LocationMessageBody.class);
        if(StringUtils.equalsIgnoreCase("Station", parsedMessage.getBodyType())) {
            dbAccessClient.postStation(mapper.toStation(parsedMessage));
        }
    }

    private void saveSystem(String systemMessage) throws JsonProcessingException {
        var parsedMessage = objectMapper.readValue(getMessageBody(systemMessage), JournalMessageBody.class); 
        dbAccessClient.postSystem(mapper.toSystem(parsedMessage));
    }

    private void logUnrecognizedMessage(String message) {
        String schemaRef = JsonPath.read(message, "$.$schemaRef");
        String event = "";
        try {
            event = JsonPath.read(message, "$.message.event");
        } catch (Exception e) {
            //consume silently
        }
        var key = schemaRef + "/" + event;

        if(!unrecognizedMap.containsKey(key)) {
            log.info("Encountered unrecognized message: {}", key);
            unrecognizedMap.put(key, message);
            var file = new File("unrecognized.txt");
            try(var fileWriter = new FileWriter(file)) {
                fileWriter.append(unrecognizedMap.values().toString());
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private String getMessageBody(String message) throws JsonProcessingException{
        return objectMapper.readTree(message).path("message").toString();
    }
}
