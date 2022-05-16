package demo.elitedata.zmqconsumer.model.zmq.commodities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;

@Data
public class CommodityZmq {
    @JsonAlias("name")
    @JsonPropertyDescription("Symbolic name as returned by the Companion API")
    private String commodityName;

    private Long meanPrice;

    @JsonPropertyDescription("Price to buy from the market")
    private Long buyPrice;

    @JsonAlias("stock")
    private Long supply;

    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private Long stockBracket;

    @JsonPropertyDescription("Price to sell to the market")
    private Long sellPrice;

    private Long demand;

    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private Long demandBracket;

    private List<String> statusFlags;

    @JsonAlias("Producer")
    private Object producer;

    @JsonAlias("Rare")
    private Object rare;

    private Object id;
}
