package za.co.valr.valrtest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.repository.OrderBookRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class OrderBookServiceImplTest {
    private OrderBookServiceImpl orderBookService;
    private OrderBookRepository orderBookRepository;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
        this.orderBookRepository = Mockito.mock(OrderBookRepository.class);
        this.orderBookService = new OrderBookServiceImpl();
        this.orderBookService.setOrderBookRepository(orderBookRepository);
    }

    @Test
    void getOrderBook() throws IOException {
        OrderBook orderBook = objectMapper.readValue(getFile("Orderbook.json"), OrderBook.class);
        Mockito.when(orderBookRepository.findByCurrencyPair("BTCZAR"))
                .thenReturn(orderBook);

        OrderBook result = orderBookService.getOrderBook("BTCZAR");
        OrderBook expResult = objectMapper.readValue(getFile("Orderbook.json"), OrderBook.class);
        assertEquals(expResult, result);
    }

    File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("data/"+fileName).getFile());
    }
}