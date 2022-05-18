package demo.elitedata.zmqconsumer.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SystemEntity {
    private String name;

    private BigDecimal posX;
    private BigDecimal posY;
    private BigDecimal posZ;

    private List<Station> stations;
}
