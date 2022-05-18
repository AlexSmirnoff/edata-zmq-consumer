package demo.elitedata.zmqconsumer.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import demo.elitedata.zmqconsumer.model.dto.Commodity;
import demo.elitedata.zmqconsumer.model.dto.Station;
import demo.elitedata.zmqconsumer.model.dto.SystemEntity;
import demo.elitedata.zmqconsumer.model.zmq.commodities.CommoditiesMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.commodities.CommodityZmq;
import demo.elitedata.zmqconsumer.model.zmq.journal.JournalMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.journal.location.LocationMessageBody;

@Mapper(componentModel = "spring", imports = BigDecimal.class)
public interface EdMapper {
    @Mapping(target = "posX", expression = "java(dto.getStarPos()[0])")
    @Mapping(target = "posY", expression = "java(dto.getStarPos()[1])")
    @Mapping(target = "posZ", expression = "java(dto.getStarPos()[2])")
    @Mapping(target = "name", source = "systemName")
    SystemEntity toSystem(JournalMessageBody dto);

    @Mapping(target = "systemName", source = "starSystem")
    @Mapping(target = "stationName", source = "body")
    Station toStation(LocationMessageBody dto);

    @Mapping(target = "commodities", expression = "java(toCommodityList(dto))")
    Station toStation(CommoditiesMessageBody dto);

    default List<Commodity> toCommodityList(CommoditiesMessageBody dto) {
        return dto.getCommodities().stream().map(commodities -> toCommodity(commodities, dto.getSystemName(), dto.getStationName())).collect(Collectors.toList());
    }

    @Mapping(target = "commodityName", expression = "java(dto.getCommodityName().toLowerCase())")
    Commodity toCommodity(CommodityZmq dto, String systemName, String stationName);
}