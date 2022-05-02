package demo.elitedata.zmqconsumer.model.zmq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class EddnMessage {
    @JsonProperty("$schemaRef")
    private String $schemaRef;
    private Header header;
}
