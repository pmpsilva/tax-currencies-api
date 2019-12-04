package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.COUNTRY)
@AllArgsConstructor
@Api(value = "Country Controller",  tags = {"Country"})
public class CountryController {

    private CountryService service;

    @GetMapping
    @ApiOperation(value = "Get all countries", nickname = "findAllCountries", response = Country.class)
    public List<Country> findAllCountries() {
        return service.findAllCountries();
    }
    @GetMapping(PathAPI.CODE)
    @ApiOperation(value = "Get Country by code (ALPHA-2 ex 'PT')", nickname = "findCountryByCode", response = Country.class)
    public Country findCountryByCode(@PathVariable("code") String code){
        return service.findCountryByCode(code);
    }

    @GetMapping(PathAPI.NAME)
    @ApiOperation(value = "Get Country by name ", nickname = "findCountryByName", response = Country.class)
    public Country findCountryByName(@PathVariable("name") String name){
        return service.findCountryByName(name);
    }

    @GetMapping(PathAPI.ISO_NAME)
    @ApiOperation(value = "Get Country by isoCode (ALPHA-3 ex 'PRT')", nickname = "findCountryByIsoName", response = Country.class)
    public Country findCountryByIsoName(@PathVariable("code3") String isoName){
        return service.findCountryByIsoCode(isoName);
    }

    @GetMapping(PathAPI.LANG_CODE)
    @ApiOperation(value = "Get Country by language (639-3 ex 'por')", nickname = "findCountryByLanguage", response = Country.class)
    public Country findCountryByLanguageCode(@PathVariable("code") String code){
        return service.findCountryByLanguageCode(code);
    }

    @GetMapping(PathAPI.CURRENCY_NAME)
    @ApiOperation(value = "Get Country by language (ISO 4217 ex 'EUR')", nickname = "findCountryByLanguage", response = Country.class)
    public Country findCountryByCurrency(@PathVariable("name") String name){
        return service.findCountryByCurrency(name);
    }

}
