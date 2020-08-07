package za.co.valr.valrtest.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderBook {
    private List<Ask> asks;
    private List<Bid> bids;
    private LocalDateTime lastChange;
}
