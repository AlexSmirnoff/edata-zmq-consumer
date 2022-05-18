package demo.elitedata.zmqconsumer.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private String stationName;
    private String systemName;
    private BigDecimal distFromStarLs;
    private List<Commodity> commodities;
}
