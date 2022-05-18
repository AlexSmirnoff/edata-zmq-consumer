package demo.elitedata.zmqconsumer.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Commodity {
    private String systemName;
    private String stationName;
    private String commodityName;
    private Long demand;
    private BigDecimal sellPrice;
    private Long supply;
    private BigDecimal buyPrice;
}
