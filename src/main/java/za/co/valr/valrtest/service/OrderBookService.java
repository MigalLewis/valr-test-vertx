package za.co.valr.valrtest.service;

import za.co.valr.valrtest.model.OrderBook;

public interface OrderBookService {
    OrderBook getOrderBook(String currencyPair);
}
