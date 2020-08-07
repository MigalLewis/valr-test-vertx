package za.co.valr.valrtest.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
public class TradeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
    @Column
    private BigDecimal price;
    @Column
    private double quantity;
    @Column
    private String currencyPair;
    @Column
    private LocalDateTime tradedAt;
    @Column
    private String takerSide;
    @Column
    private int sequenceId;
    @Column
    private double quoteVolume;
}
