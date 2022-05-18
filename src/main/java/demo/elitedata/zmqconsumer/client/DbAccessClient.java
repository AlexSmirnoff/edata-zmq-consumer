package demo.elitedata.zmqconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import demo.elitedata.zmqconsumer.model.dto.Station;
import demo.elitedata.zmqconsumer.model.dto.SystemEntity;

@FeignClient(name = "db-access", url = "${db-access.url}")
public interface DbAccessClient {
	@PostMapping("/system")
    public SystemEntity postSystem(@RequestBody SystemEntity system);

    @PostMapping("/station")
    public Station postStation(@RequestBody Station station);
}