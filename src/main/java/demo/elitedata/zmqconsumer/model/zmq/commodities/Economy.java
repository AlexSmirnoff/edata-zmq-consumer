package demo.elitedata.zmqconsumer.model.zmq.commodities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Data
public class Economy {
    @JsonProperty("name")
    @JsonPropertyDescription("Economy type as returned by the Companion API")
    private String name;

    @JsonProperty("proportion")
    private Double proportion;

}
