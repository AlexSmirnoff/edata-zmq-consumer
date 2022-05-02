package demo.elitedata.zmqconsumer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "system", schema = "edata")
public class SystemEntity {
    @Id
    private String name;

    private BigDecimal posX;
    private BigDecimal posY;
    private BigDecimal posZ;

    @OneToMany
    @JoinColumn(name = "systemName", insertable = false, updatable = false)
    private List<Station> stations;
}
