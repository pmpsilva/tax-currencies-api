package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.repository.CurrencyRepository;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository repository;

    public List<Currency> findAllCurrencies() {
        log.info("Find all currencies called");
        return repository.findAll();
    }

    public List<Currency> findCurrenciesBySymbol(String symbol) {
        log.info("Find all currencies with symbol {}", symbol);
        return repository.findCurrencyBySymbolIgnoreCase(symbol);
    }

    public List<Currency> findCurrenciesByName(String name) {
        log.info("Find all currencies with name {}", name);
        return repository.findCurrencyByNameIgnoreCase(name);
    }

    public Currency findCurrencyByCode(String code) throws CustomException {
        log.info("Find currency by code: {}", code);
        return repository.findCurrencyByCodeIgnoreCase(code)
                .orElseThrow(() -> {
                    log.error("Can't find any currency for  code {}", code);
                    return new CustomException("Currency not found for code " + code,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Currency create(Currency currency) throws CustomException {
        try {
            log.info("Create new currency: {}", currency);
            return repository.save(currency);
        } catch (DataIntegrityViolationException e) {
            log.error("Can't create the currency {}, cause: {}", currency.getCode(), e.getMostSpecificCause());
            throw new CustomException("Can't create the currency " + currency.getCode(), e.getMostSpecificCause());
        } catch (Exception e) {
            log.error("Can't create the currency {}, cause: {}",  currency.getCode(), e.getCause());
            throw new CustomException("Can't create the currency " + currency.getCode(), e.getCause());
        }

    }
}
