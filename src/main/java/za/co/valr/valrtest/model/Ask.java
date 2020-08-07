package za.co.valr.valrtest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Ask {
    @Id
    @GeneratedValue
    private Long id;
    private String side;
    private double quantity;
    private BigDecimal price;
    private String currencyPair;
    private int orderCount;
}
