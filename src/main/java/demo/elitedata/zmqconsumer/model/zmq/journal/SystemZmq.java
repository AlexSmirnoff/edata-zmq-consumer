package demo.elitedata.zmqconsumer.model.zmq.journal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemZmq {
    @JsonProperty("StarPos")
	private BigDecimal[] starPos;

    @JsonAlias({"StarSystem", "SystemName"})
    private String systemName;

    private String stationName;
}