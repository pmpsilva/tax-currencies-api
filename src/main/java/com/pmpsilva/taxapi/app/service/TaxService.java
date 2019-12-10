package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Tax;
import com.pmpsilva.taxapi.app.database.repository.TaxRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TaxService {
    private TaxRepository repository;

    public List<Tax> findTaxesByCountryCode(String countryCode){
        return repository.findTaxByCountryCodeIgnoreCase(countryCode);
    }

    public List<Tax> findTaxByRegionCode(String countryCode){
        return repository.findTaxByRegionCodeIgnoreCase(countryCode);
    }
}
