package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.database.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository repository;

    public List<Country> findAllCountries() {
        return repository.findAll();
    }


}
