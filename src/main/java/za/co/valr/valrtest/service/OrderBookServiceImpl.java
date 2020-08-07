package za.co.valr.valrtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.repository.OrderBookRepository;

@Service("orderBook")
public class OrderBookServiceImpl implements OrderBookService {
    private OrderBookRepository orderBookRepository;

    @Override
    public OrderBook getOrderBook(String currencyPair) {
        return orderBookRepository.findByCurrencyPair(currencyPair);
    }

    @Autowired
    public void setOrderBookRepository(OrderBookRepository orderBookRepository) {
        this.orderBookRepository = orderBookRepository;
    }
}
