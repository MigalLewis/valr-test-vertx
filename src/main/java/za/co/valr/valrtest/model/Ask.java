package za.co.valr.valrtest.model;

import lombok.Data;

@Data
public class Ask {
    private String side;
    private String quantity;
    private String price;
    private String currencyPair;
    private int orderCount;
}
