package za.co.valr.valrtest.repository;
import org.springframework.data.repository.CrudRepository;
import za.co.valr.valrtest.model.OrderBookEntity;

public interface OrderBookRepository extends CrudRepository<OrderBookEntity,Long> {
    public OrderBookEntity findByCurrencyPair(String currencyPair);
}
