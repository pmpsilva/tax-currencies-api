package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository repository;

    public List<Currency> findAllCurrencies(){
        return repository.findAll();
    }
}
