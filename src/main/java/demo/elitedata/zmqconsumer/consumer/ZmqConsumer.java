package demo.elitedata.zmqconsumer.consumer;

import com.jayway.jsonpath.JsonPath;
import demo.elitedata.zmqconsumer.service.EddnMessageConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.annotation.Scheduled;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.Inflater;

@Configuration
@EnableIntegration
@RequiredArgsConstructor
@Slf4j
public class ZmqConsumer {
    private final EddnMessageConsumer messageConsumer;
    private final AtomicLong messagesPerMinute = new AtomicLong();

    @Bean
    @ServiceActivator(inputChannel = "eddnZmqChannel")
    public MessageHandler subscribe() {
        return message -> {
            byte[] output = new byte[256 * 1024];
            byte[] payload = (byte[]) message.getPayload();
            Inflater inflater = new Inflater();
            inflater.setInput(payload);
            String outputString = null;
            try {
                int outputLength = inflater.inflate(output);
                outputString = new String(output, 0, outputLength, StandardCharsets.UTF_8);
                if(outputString.contains("$schemaRef")) {
                    messagesPerMinute.incrementAndGet();
                    log.debug("Received message of type: {}", JsonPath.parse(outputString).read("$.$schemaRef", String.class));
                    messageConsumer.consumeMessage(outputString);
                }
            } catch (Exception e) {
                log.error("An exception occured. Message that caused exception: \n{}",outputString);
                log.error(e.getMessage(), e);
            }
        };
    }

    @Scheduled(fixedRate = 60*1000, initialDelay = 60*1000)
    public void logMessagesPerMinute() {
        log.info("Messages received per minute: {}", messagesPerMinute);
        messagesPerMinute.set(0L);
    }
}
