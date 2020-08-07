package za.co.valr.valrtest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.model.OrderBookEntity;

@Mapper
public interface OrderBookMapper {
    @Mappings({
            @Mapping(target="lastChange", source="entity.lastChange", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    })
    OrderBook orderBookEntityToOrderBook(OrderBookEntity entity);
}
