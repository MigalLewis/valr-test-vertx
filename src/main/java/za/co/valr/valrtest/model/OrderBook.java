package za.co.valr.valrtest.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
public class OrderBook {
    @Id
    @Column
    private int id;
    @OneToMany(mappedBy="id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ask> asks;
    @OneToMany(mappedBy="id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bid> bids;
    private LocalDateTime lastChange;
}
