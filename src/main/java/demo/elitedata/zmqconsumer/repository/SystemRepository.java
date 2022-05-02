package demo.elitedata.zmqconsumer.repository;

import demo.elitedata.zmqconsumer.model.entity.SystemEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SystemRepository extends PagingAndSortingRepository<SystemEntity, String> {

}
