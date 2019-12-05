package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Tax;
import com.pmpsilva.taxapi.app.service.TaxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(PathAPI.TAX)
@Api(value = "Tax Controller", tags = {"Taxes"})
public class TaxController {

    private TaxService service;

    @GetMapping(PathAPI.CODE)
    @ApiOperation(value = "Get Tax By Country code (ALPHA-2 ex 'PT')", nickname = "findTaxByCountryCode",
            response = Tax.class)
    public List<Tax> findTaxesByCountryCode(@PathVariable("code") String code) {
        return service.findTaxesByCountryCode(code);
    }

    @GetMapping(PathAPI.REGION+PathAPI.CODE)
    @ApiOperation(value = "Get Tax By Regiion code (ex 'PT-MA')", nickname = "findTaxByCountryCode",
            response = Tax.class)
    public List<Tax> findTaxByRegionCode(@PathVariable("code") String code) {
        return service.findTaxByRegionCode(code);
    }
}
