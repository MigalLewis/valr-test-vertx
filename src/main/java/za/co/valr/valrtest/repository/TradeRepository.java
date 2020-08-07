package za.co.valr.valrtest.repository;
import org.springframework.data.repository.CrudRepository;
import za.co.valr.valrtest.model.TradeEntity;

import java.util.UUID;

public interface TradeRepository extends CrudRepository<TradeEntity, UUID> {
    public TradeEntity findByCurrencyPair(String currencyPair);
}
