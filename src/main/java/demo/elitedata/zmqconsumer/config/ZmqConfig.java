package demo.elitedata.zmqconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.zeromq.channel.ZeroMqChannel;
import org.zeromq.ZContext;

@Configuration
@EnableIntegration
public class ZmqConfig {
    @Bean
    public ZContext zContext() {
        return new ZContext();
    }

    @Bean(name = "eddnZmqChannel")
    public ZeroMqChannel commoditiesZmqChannel(ZContext zContext) {
        ZeroMqChannel channel = new ZeroMqChannel(zContext, true);
        channel.setConnectUrl("tcp://eddn.edcd.io:9500:9500");
        return channel;
    }
}
