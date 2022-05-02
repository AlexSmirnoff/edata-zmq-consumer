package demo.elitedata.zmqconsumer.repository;

import demo.elitedata.zmqconsumer.model.entity.Station;
import demo.elitedata.zmqconsumer.model.entity.ids.StationId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StationRepository extends PagingAndSortingRepository<Station, StationId> {
}
