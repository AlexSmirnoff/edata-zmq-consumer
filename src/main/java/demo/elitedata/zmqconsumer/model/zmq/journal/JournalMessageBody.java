package demo.elitedata.zmqconsumer.model.zmq.journal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JournalMessageBody {
    private Instant timestamp;
    private String event;
    private Boolean horizons;
    private Boolean odyssey;

    @JsonAlias("SystemName")
    @JsonProperty("StarSystem")
    private String systemName;

    @JsonProperty("StarPos")
    private BigDecimal[] starPos;
}
