package demo.elitedata.zmqconsumer.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import demo.elitedata.zmqconsumer.model.entity.Commodity;
import demo.elitedata.zmqconsumer.model.entity.Station;
import demo.elitedata.zmqconsumer.model.entity.SystemEntity;
import demo.elitedata.zmqconsumer.model.zmq.commodities.CommoditiesMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.commodities.CommodityDto;
import demo.elitedata.zmqconsumer.model.zmq.journal.JournalMessageBody;
import demo.elitedata.zmqconsumer.model.zmq.journal.location.LocationDto;

@Mapper(componentModel = "spring", imports = BigDecimal.class)
public interface EdMapper {
    
    @Mapping(target = "posX", expression = "java(dto.getStarPos()[0])")
    @Mapping(target = "posY", expression = "java(dto.getStarPos()[1])")
    @Mapping(target = "posZ", expression = "java(dto.getStarPos()[2])")
    @Mapping(target = "name", source = "systemName")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SystemEntity toSystem(JournalMessageBody dto, @MappingTarget SystemEntity entity);

    @Mapping(target = "systemName", source = "starSystem")
    @Mapping(target = "stationName", source = "body")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Station toStation(LocationDto dto, @MappingTarget Station entity);

    @Mapping(target = "commodities", expression = "java(toCommodityList(dto))")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Station toStation(CommoditiesMessageBody dto, @MappingTarget Station entity);

    default List<Commodity> toCommodityList(CommoditiesMessageBody dto) {
        return dto.getCommodities().stream().map(commodities -> toCommodity(commodities, dto.getSystemName(), dto.getStationName())).collect(Collectors.toList());
    }

    @Mapping(target = "commodityName", expression = "java(dto.getCommodityName().toLowerCase())")
    Commodity toCommodity(CommodityDto dto, String systemName, String stationName);
}