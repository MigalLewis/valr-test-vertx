package za.co.valr.valrtest.repository;
import org.springframework.data.repository.CrudRepository;
import za.co.valr.valrtest.model.TradeEntity;

import java.util.List;
import java.util.UUID;

public interface TradeRepository extends CrudRepository<TradeEntity, UUID> {
    public List<TradeEntity> findByCurrencyPair(String currencyPair);
}
