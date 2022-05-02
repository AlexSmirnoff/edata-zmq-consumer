package demo.elitedata.zmqconsumer.model.entity;

import demo.elitedata.zmqconsumer.model.entity.ids.CommodityId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "listing", schema = "edata")
@IdClass(CommodityId.class)
public class Commodity {
    @Id
    private String systemName;
    @Id
    private String stationName;
    @Id
    private String commodityName;
    private Long demand;
    private BigDecimal sellPrice;
    private Long supply;
    private BigDecimal buyPrice;
}
