package za.co.valr.valrtest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import za.co.valr.valrtest.mapper.OrderBookMapper;
import za.co.valr.valrtest.model.Ask;
import za.co.valr.valrtest.model.Bid;
import za.co.valr.valrtest.model.OrderBookEntity;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.repository.OrderBookRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderBookEntityServiceImplTest {
    private OrderBookServiceImpl orderBookService;
    private OrderBookRepository orderBookRepository;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
        this.orderBookRepository = Mockito.mock(OrderBookRepository.class);
        this.orderBookService = new OrderBookServiceImpl();
        this.orderBookService.setOrderBookRepository(orderBookRepository);
        this.orderBookService.setOrderBookMapper(Mappers.getMapper(OrderBookMapper.class));
    }

    @Test
    void getOrderBook() throws IOException {
        OrderBookEntity orderBookEntity = objectMapper.readValue(getFile("Orderbook.json"), OrderBookEntity.class);
        Mockito.when(orderBookRepository.findByCurrencyPair("BTCZAR"))
                .thenReturn(orderBookEntity);

        OrderBook result = orderBookService.getOrderBook("BTCZAR");
        OrderBook expResult = new OrderBook();
        expResult.setAsks(new ArrayList<>());
        setAsks(expResult.getAsks());
        expResult.setBids(new ArrayList<>());
        setBids(expResult.getBids());
        expResult.setLastChange("2020-08-07T06:54:18.261Z");
        assertEquals(expResult, result);
    }
    File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("data/"+fileName).getFile());
    }

    void setAsks(List<Ask> asks) {
        asks.add(new Ask());
        asks.get(0).setCurrencyPair("BTCZAR");
        asks.get(0).setOrderCount(13);
        asks.get(0).setQuantity("2.57680846");
        asks.get(0).setSide("sell");
        asks.get(0).setPrice("215413");
        asks.add(new Ask());
        asks.get(1).setCurrencyPair("BTCZAR");
        asks.get(1).setOrderCount(2);
        asks.get(1).setQuantity("0.7574323");
        asks.get(1).setSide("sell");
        asks.get(1).setPrice("215600");
        asks.add(new Ask());
        asks.get(2).setCurrencyPair("BTCZAR");
        asks.get(2).setOrderCount(1);
        asks.get(2).setQuantity("0.135339");
        asks.get(2).setSide("sell");
        asks.get(2).setPrice("215601");
    }
    void setBids(List<Bid> bids) {
        bids.add(new Bid());
        bids.get(0).setCurrencyPair("BTCZAR");
        bids.get(0).setOrderCount(7);
        bids.get(0).setQuantity("10.92911387");
        bids.get(0).setSide("buy");
        bids.get(0).setPrice("215412");
        bids.add(new Bid());
        bids.get(1).setCurrencyPair("BTCZAR");
        bids.get(1).setOrderCount(1);
        bids.get(1).setQuantity("0.025");
        bids.get(1).setSide("buy");
        bids.get(1).setPrice("214701");
        bids.add(new Bid());
        bids.get(2).setCurrencyPair("BTCZAR");
        bids.get(2).setOrderCount(1);
        bids.get(2).setQuantity("0.0349367");
        bids.get(2).setSide("buy");
        bids.get(2).setPrice("214700");
    }
}