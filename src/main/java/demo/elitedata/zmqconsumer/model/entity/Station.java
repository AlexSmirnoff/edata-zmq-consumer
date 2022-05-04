package demo.elitedata.zmqconsumer.model.entity;

import demo.elitedata.zmqconsumer.model.entity.ids.StationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station", schema = "ed")
@IdClass(StationId.class)
public class Station {
    @Id
    private String stationName;
    @Id
    private String systemName;

    private BigDecimal distFromStarLs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemName", insertable = false, updatable = false)
    @JoinColumn(name = "stationName", insertable = false, updatable = false)
    private List<Commodity> commodities;
}
