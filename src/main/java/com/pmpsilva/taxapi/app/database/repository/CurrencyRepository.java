package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Optional<Currency> findCurrencyByCodeIgnoreCase(String code);

    List<Currency> findCurrencyBySymbolIgnoreCase(String symbol);

    List<Currency> findCurrencyByNameIgnoreCase(String name);

}
