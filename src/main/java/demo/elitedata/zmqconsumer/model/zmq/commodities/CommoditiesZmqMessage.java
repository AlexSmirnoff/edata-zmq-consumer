package demo.elitedata.zmqconsumer.model.zmq.commodities;

import demo.elitedata.zmqconsumer.model.zmq.EddnMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CommoditiesZmqMessage extends EddnMessage {
    private CommoditiesMessageBody message;
}
