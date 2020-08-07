package za.co.valr.valrtest.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class BidEntity {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String side;
    @Column
    private double quantity;
    @Column
    private BigDecimal price;
    @Column
    private String currencyPair;
    @Column
    private int orderCount;
}
