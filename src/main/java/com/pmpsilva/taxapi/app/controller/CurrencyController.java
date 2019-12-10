package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import com.pmpsilva.taxapi.app.error.ValidatorUtils;
import com.pmpsilva.taxapi.app.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.CURRENCY)
@AllArgsConstructor
@Api(value = "Currency Controller", tags = {"Currency"})
public class CurrencyController {
    private CurrencyService service;

    @GetMapping
    @ApiOperation(value = "Get all currencies", nickname = "findAllCurrencies",
            response = Currency.class)
    public List<Currency> findAllCurrencies() {
        return service.findAllCurrencies();
    }

    @GetMapping(PathAPI.CODE)
    @ApiOperation(value = "Get currency by code (ISO 4217 ex 'EUR')", nickname = "findCurrencyByCode",
            response = Currency.class)
    public Currency findCurrencyByCode(@PathVariable("code") String code) throws CustomException {
        return service.findCurrencyByCode(code);
    }

    @GetMapping(PathAPI.SYMBOL)
    @ApiOperation(value = "Get Currencies by Symbol (ex '€')", nickname = "findCurrenciesBySymbol",
            response = Currency.class)
    public List<Currency> findCurrencyBySymbol(@PathVariable("symbol") String symbol) throws CustomException {
        return service.findCurrenciesBySymbol(symbol);
    }

    @GetMapping(PathAPI.NAME)
    @ApiOperation(value = "Get Currencies by name (ex 'Euro')", nickname = "findCurrenciesByName",
            response = Currency.class)
    public List<Currency> findCurrencyByName(@PathVariable("name") String name) throws CustomException {
        return service.findCurrenciesByName(name);
    }

    @PostMapping
    @ApiOperation(value = "Create new currency", nickname = "createCurrency")
    public Currency create(
            @ApiParam(name = "Currency details")
            @RequestBody Currency currency) throws CustomException {
        if (ValidatorUtils.isValidCurrency(currency)) {
            return service.create(currency);
        } else {
            throw new CustomException("Invalid Currency Object",
                    new Throwable(String.valueOf(ErrorCode.INVALID_INPUT)));
        }
    }
}
