package za.co.valr.valrtest.model;

import lombok.Data;

@Data
public class Trade {
    private String id;
    private String price;
    private String quantity;
    private String currencyPair;
    private String tradedAt;
    private String takerSide;
    private int sequenceId;
    private String quoteVolume;
}
