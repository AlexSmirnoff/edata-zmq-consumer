package demo.elitedata.zmqconsumer.model.zmq.journal;

import demo.elitedata.zmqconsumer.model.zmq.EddnMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class JournalZmqMessage extends EddnMessage {
    private JournalMessageBody message;
}
