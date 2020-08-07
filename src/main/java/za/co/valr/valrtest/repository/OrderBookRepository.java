package za.co.valr.valrtest.repository;
import org.springframework.data.repository.CrudRepository;
import za.co.valr.valrtest.model.OrderBook;

public interface OrderBookRepository extends CrudRepository<OrderBook,Integer> {
    public OrderBook findByCurrencyPair(String currencyPair);
}
