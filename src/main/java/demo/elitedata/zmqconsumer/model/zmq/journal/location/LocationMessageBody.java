
package demo.elitedata.zmqconsumer.model.zmq.journal.location;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LocationMessageBody {

    @JsonAlias("Body")
    public String body;
    @JsonAlias("BodyID")
    public Long bodyID;
    @JsonAlias("BodyType")
    public String bodyType;
    @JsonAlias("DistFromStarLS")
    public BigDecimal distFromStarLs;
    @JsonAlias("StarPos")
    public BigDecimal[] starPos;
    @JsonAlias("StarSystem")
    public String starSystem;
    @JsonAlias("StationName")
    public String stationName;
    @JsonAlias("StationType")
    public String stationType;
    @JsonAlias("event")
    public String event;
}
