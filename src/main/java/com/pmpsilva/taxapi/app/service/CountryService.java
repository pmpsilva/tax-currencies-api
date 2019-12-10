package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.database.repository.CountryRepository;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CountryService {

    private CountryRepository repository;


    public List<Country> findAllCountries() {
        log.info("Find All countries called");
        return repository.findAll();
    }

    public Country findCountryByCode(String code) throws CustomException {

        log.info("findCountry to code: {}", code);
        return repository.findCountryByCodeIgnoreCase(code)
                .orElseThrow(() -> {
                    log.error("Can't find Country to Code {}", code);
                    return new CustomException("Country not found for code " + code,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Country findCountryByName(String name) throws CustomException {
        log.info("Find country to name: {}", name);
        return repository.findCountryByNameIgnoreCase(name)
                .orElseThrow(() -> {
                    log.error("Can't find a country for name {}", name);
                    return new CustomException("Country not found for name " + name,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Country findCountryByIsoCode(String isoCode) throws CustomException {
        log.info("Find country by isoCode: {}", isoCode);
        return repository.findCountryByIsoNameIgnoreCase(isoCode)
                .orElseThrow(() -> {
                    log.error("Can't find a country for isoCode {}", isoCode);
                    return new CustomException("Country not found for code " + isoCode,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Country findCountryByLanguageCode(String langCode) throws CustomException {
        log.info("Find country by langCode: {}", langCode);
        return repository.findCountryByLanguageCodeIgnoreCase(langCode)
                .orElseThrow(() -> {
                    log.error("Can't find a country for language {}", langCode);
                    return new CustomException("Country not found for language " + langCode,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Country findCountryByCurrency(String currency) throws CustomException {
        log.info("Find country by currency: {}", currency);
        return repository.findCountryByCurrencyCodeIgnoreCase(currency)
                .orElseThrow(() -> {
                    log.error("Can't find a country for currency {}", currency);
                    return new CustomException("Country not found for currency " + currency,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }
}
