package za.co.valr.valrtest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.valr.valrtest.mapper.OrderBookMapper;
import za.co.valr.valrtest.model.OrderBookEntity;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.repository.OrderBookRepository;

import java.io.File;
import java.io.IOException;

@Service("orderBook")
public class OrderBookServiceImpl implements OrderBookService {
    private OrderBookRepository orderBookRepository;
    private OrderBookMapper orderBookMapper;

    @Override
    public OrderBook getOrderBook(String currencyPair) {
        OrderBookEntity orderBookEntity = orderBookRepository.findByCurrencyPair(currencyPair);
        OrderBook orderBookResponse = orderBookMapper.orderBookEntityToOrderBook(orderBookEntity);
        return orderBookResponse;
    }

    void saveOrderBook() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderBookEntity orderBookEntity = objectMapper.readValue(getFile("Orderbook.json"), OrderBookEntity.class);
        orderBookRepository.save(orderBookEntity);
    }

    File getFile(String fileName) {
        return new File("/home/migal/Projects/forHome/valr/valr-test/src/main/resources/data/Orderbook.json");
    }

    @Autowired
    public void setOrderBookRepository(OrderBookRepository orderBookRepository) {
        this.orderBookRepository = orderBookRepository;
    }

    @Autowired
    public void setOrderBookMapper(OrderBookMapper orderBookMapper) {
        this.orderBookMapper = orderBookMapper;
    }
}
