package demo.elitedata.zmqconsumer.model.zmq.commodities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
public class CommodityDto {
    @JsonProperty("name")
    @JsonPropertyDescription("Symbolic name as returned by the Companion API")
    private String commodityName;

    @JsonProperty("meanPrice")
    private Long meanPrice;

    @JsonProperty("buyPrice")
    @JsonPropertyDescription("Price to buy from the market")
    private Long buyPrice;

    @JsonProperty("stock")
    private Long supply;

    @JsonProperty("stockBracket")
    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private Long stockBracket;

    @JsonProperty("sellPrice")
    @JsonPropertyDescription("Price to sell to the market")
    private Long sellPrice;

    @JsonProperty("demand")
    private Long demand;

    @JsonProperty("demandBracket")
    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private Long demandBracket;

    @JsonProperty("statusFlags")
    @Field(type = FieldType.Text, includeInParent = true)
    private List<String> statusFlags;

    @JsonProperty("Producer")
    private Object producer;

    @JsonProperty("Rare")
    private Object rare;

    @JsonProperty("id")
    private Object id;
}
