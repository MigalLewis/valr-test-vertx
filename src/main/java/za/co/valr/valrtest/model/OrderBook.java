package za.co.valr.valrtest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
    @Column
    private String currencyPair;
    @JsonProperty("Asks")
    @OneToMany(mappedBy="id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ask> asks;
    @JsonProperty("Bids")
    @OneToMany(mappedBy="id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bid> bids;
    @JsonProperty("LastChange")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column
    private LocalDateTime lastChange;
}
