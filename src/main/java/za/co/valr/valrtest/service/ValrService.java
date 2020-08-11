package za.co.valr.valrtest.service;

import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.model.Trade;

import java.util.List;

public interface ValrService {
    OrderBook getOrderBook(String currencyPair);
    List<Trade> getAllTrades(String currencyPair);

}
