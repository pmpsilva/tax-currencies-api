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

    public Country findCountryByCode(String code){
        return repository.findCountryByCodeIgnoreCase(code).get();
    }

    public Country findCountryByName(String name){
        return repository.findCountryByNameIgnoreCase(name).get();
    }

    public Country findCountryByIsoCode(String isoCode){
        return repository.findCountryByIsoNameIgnoreCase(isoCode).get();
    }
    public Country findCountryByLanguageCode(String isoCode){
        return repository.findCountryByLanguageCodeIgnoreCase(isoCode).get();
    }

    public Country findCountryByCurrency(String name){
        return repository.findCountryByCurrencyCodeIgnoreCase(name).get();
    }


}
