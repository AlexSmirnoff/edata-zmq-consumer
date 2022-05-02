package demo.elitedata.zmqconsumer.model.zmq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uploaderID",
    "softwareName",
    "softwareVersion",
    "gatewayTimestamp"
})
@Generated("jsonschema2pojo")
@Data
public class Header {
    @JsonProperty("uploaderID")
    private String uploaderID;

    @JsonProperty("softwareName")
    private String softwareName;

    @JsonProperty("softwareVersion")
    private String softwareVersion;

    @JsonProperty("gatewayTimestamp")
    @JsonPropertyDescription("Timestamp upon receipt at the gateway. If present, this property will be overwritten by the gateway; submitters are not intended to populate this property.")
    private Date gatewayTimestamp;

}
