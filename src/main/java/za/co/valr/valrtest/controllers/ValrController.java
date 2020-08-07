package za.co.valr.valrtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.valr.valrtest.model.OrderBook;
import za.co.valr.valrtest.service.OrderBookService;

@RestController
public class ValrController {
    @Autowired
    private OrderBookService orderBookService;

    @GetMapping("{currencyPair}/orderbook")
    public @ResponseBody OrderBook getOrderBook(@PathVariable String currencyPair) {
        return this.orderBookService.getOrderBook(currencyPair);
    }
}
