package demo.elitedata.zmqconsumer.service;

public interface EddnMessageConsumer {
    void consumeMessage(String message);
}
