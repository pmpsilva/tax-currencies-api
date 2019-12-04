package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findCountryByCodeIgnoreCase(String code);

    Optional<Country> findCountryByNameIgnoreCase(String name);

    Optional<Country> findCountryByIsoNameIgnoreCase(String isoName);

    Optional<Country> findCountryByLanguageCodeIgnoreCase(String code);

    Optional<Country> findCountryByCurrencyCodeIgnoreCase(String code);
}
