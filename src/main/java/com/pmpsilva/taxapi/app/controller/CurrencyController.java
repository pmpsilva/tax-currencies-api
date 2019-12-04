package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.service.CurrencyService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.CURRENCY)
@AllArgsConstructor
@Api(value = "Currency Controller",  tags = {"Currency"})
public class CurrencyController {
    private CurrencyService service;

    @GetMapping
    public List<Currency> findAllCurrencies(){
        return service.findAllCurrencies();
    }
}
