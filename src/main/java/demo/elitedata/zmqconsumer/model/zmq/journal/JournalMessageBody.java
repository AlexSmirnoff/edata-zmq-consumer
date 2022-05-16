package demo.elitedata.zmqconsumer.model.zmq.journal;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JournalMessageBody {
    private Instant timestamp;
    private String event;
    private Boolean horizons;
    private Boolean odyssey;

    @JsonAlias({"SystemName", "StarSystem"})
    private String systemName;

    @JsonAlias("StarPos")
    private BigDecimal[] starPos;
}
