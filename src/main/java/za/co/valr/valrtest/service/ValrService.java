package za.co.valr.valrtest.service;

import za.co.valr.valrtest.model.OrderBook;

public interface ValrService {
    OrderBook getOrderBook(String currencyPair);

}
