package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.repository.CurrencyRepository;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository repository;

    public List<Currency> findAllCurrencies() {
        return repository.findAll();
    }

    public Currency create(Currency currency) throws CustomException {
        try {
            return repository.save(currency);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("Can't create the currency " + currency.getCode(),
                    new Throwable(String.valueOf(ErrorCode.DUPPLICATED_CURRENCY)));
        } catch (Exception e) {
            throw new CustomException("Can't create the currency " + currency.getCode(), e.getCause());
        }

    }
}
