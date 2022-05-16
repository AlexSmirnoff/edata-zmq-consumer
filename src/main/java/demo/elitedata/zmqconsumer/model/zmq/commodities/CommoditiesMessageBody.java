package demo.elitedata.zmqconsumer.model.zmq.commodities;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class CommoditiesMessageBody {
    private String systemName;

    private String stationName;

    private Long marketId;

    private Boolean horizons;

    private Boolean odyssey;

    private Date timestamp;

    private List<CommodityZmq> commodities = Collections.emptyList();

    private List<EconomyZmq> economies = Collections.emptyList();

    private List<String> prohibited;

    @JsonAlias("StationType")
    private Object stationType;

}
