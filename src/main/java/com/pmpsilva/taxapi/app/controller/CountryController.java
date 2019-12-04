package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.COUNTRY)
@AllArgsConstructor
public class CountryController {

    private CountryService service;

    @GetMapping
    public List<Country> findAllCountries() {
        return service.findAllCountries();
    }

}
