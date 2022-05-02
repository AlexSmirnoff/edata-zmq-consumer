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
public class SystemDto {
    @JsonProperty("StarPos")
	private BigDecimal[] starPos;

    @JsonAlias("SystemName")
    @JsonProperty("StarSystem")
    private String systemName;

    @JsonProperty("")
    private String stationName;
}