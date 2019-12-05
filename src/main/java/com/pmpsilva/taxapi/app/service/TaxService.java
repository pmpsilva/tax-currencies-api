package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Tax;
import com.pmpsilva.taxapi.app.database.repository.TaxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
