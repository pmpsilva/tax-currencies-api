package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
