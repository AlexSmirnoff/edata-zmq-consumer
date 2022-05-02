
package demo.elitedata.zmqconsumer.model.zmq.journal.location;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LocationDto {

    @JsonProperty("Body")
    public String body;
    @JsonProperty("BodyID")
    public Long bodyID;
    @JsonProperty("BodyType")
    public String bodyType;
    @JsonProperty("DistFromStarLS")
    public BigDecimal distFromStarLs;
    @JsonProperty("StarPos")
    public BigDecimal[] starPos;
    @JsonProperty("StarSystem")
    public String starSystem;
    @JsonProperty("StationName")
    public String stationName;
    @JsonProperty("StationType")
    public String stationType;
    @JsonProperty("event")
    public String event;
}
