package za.co.valr.valrtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.valr.valrtest.mapper.OrderBookMapper;
import za.co.valr.valrtest.model.OrderBookEntity;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.repository.OrderBookRepository;


@Service("orderBook")
public class ValrServiceImpl implements ValrService {
    private OrderBookRepository orderBookRepository;
    private OrderBookMapper orderBookMapper;

    @Override
    public OrderBook getOrderBook(String currencyPair) {
        OrderBookEntity orderBookEntity = orderBookRepository.findByCurrencyPair(currencyPair);
        return orderBookMapper.orderBookEntityToOrderBook(orderBookEntity);
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
