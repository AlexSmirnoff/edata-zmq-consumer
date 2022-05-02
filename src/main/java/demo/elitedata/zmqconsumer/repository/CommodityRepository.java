package demo.elitedata.zmqconsumer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import demo.elitedata.zmqconsumer.model.entity.Commodity;
import demo.elitedata.zmqconsumer.model.entity.ids.CommodityId;

public interface CommodityRepository extends PagingAndSortingRepository<Commodity, CommodityId>{}