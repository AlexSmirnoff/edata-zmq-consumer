package demo.elitedata.zmqconsumer.model.zmq.commodities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@Document(indexName = "commodities")
public class CommoditiesMessageBody {
    @JsonProperty("systemName")
    private String systemName;

    @JsonProperty("stationName")
    @Id
    private String stationName;

    @JsonProperty("marketId")
    private Long marketId;

    @JsonProperty("horizons")
    @JsonPropertyDescription("Whether the sending Cmdr has a Horizons pass.")
    private Boolean horizons;

    @JsonProperty("odyssey")
    @JsonPropertyDescription("Whether the sending Cmdr has an Odyssey expansion.")
    private Boolean odyssey;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("commodities")
    @JsonPropertyDescription("Commodities returned by the Companion API, with illegal commodities omitted")
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<CommodityDto> commodities = Collections.emptyList();

    @JsonProperty("economies")
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Economy> economies = Collections.emptyList();

    @JsonProperty("prohibited")
    @Field(type = FieldType.Text, includeInParent = true)
    private List<String> prohibited;

    @JsonProperty("StationType")
    private Object stationType;

}
