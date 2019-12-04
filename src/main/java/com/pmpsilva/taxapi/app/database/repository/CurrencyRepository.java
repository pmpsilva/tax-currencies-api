package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
