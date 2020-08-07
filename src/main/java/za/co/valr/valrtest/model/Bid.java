package za.co.valr.valrtest.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bid {
    private String side;
    private double quantity;
    private BigDecimal price;
    private String currencyPair;
    private int orderCount;
}
