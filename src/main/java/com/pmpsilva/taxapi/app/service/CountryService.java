package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.database.repository.CountryRepository;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
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

    public Country findCountryByCode(String code) throws CustomException {

        return repository.findCountryByCodeIgnoreCase(code)
                .orElseThrow(() -> new CustomException("Country not found for code " + code,
                        new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND))));
    }

    public Country findCountryByName(String name) throws CustomException {
        return repository.findCountryByNameIgnoreCase(name)
                .orElseThrow(() -> new CustomException("Country not found for name " + name));
    }

    public Country findCountryByIsoCode(String isoCode) throws CustomException {
        return repository.findCountryByIsoNameIgnoreCase(isoCode)
                .orElseThrow(() -> new CustomException("Country not found for code " + isoCode));
    }

    public Country findCountryByLanguageCode(String isoCode) throws CustomException {
        return repository.findCountryByLanguageCodeIgnoreCase(isoCode)
                .orElseThrow(() -> new CustomException("Country not found for language " + isoCode));
    }

    public Country findCountryByCurrency(String name) throws CustomException {
        return repository.findCountryByCurrencyCodeIgnoreCase(name)
                .orElseThrow(() -> new CustomException("Country not found for currency " + name));
    }


}
