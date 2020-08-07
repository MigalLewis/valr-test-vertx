package za.co.valr.valrtest.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.valr.valrtest.mapper.OrderBookMapper;

@Configuration
public class BeanConfig {

    @Bean
    public OrderBookMapper orderBookMapper() {
        return Mappers.getMapper(OrderBookMapper.class);
    }

}
