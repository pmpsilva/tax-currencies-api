package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {

    List<Tax> findTaxByCountryCodeIgnoreCase(String code);
    List<Tax> findTaxByRegionCodeIgnoreCase(String code);
}
