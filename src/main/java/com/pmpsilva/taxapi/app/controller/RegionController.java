package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Country;
import com.pmpsilva.taxapi.app.database.domain.Region;
import com.pmpsilva.taxapi.app.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(PathAPI.REGION)
@Api(value = "Regions Controller",  tags = {"Regions"})
public class RegionController {
    private RegionService service;

    @GetMapping
    @ApiOperation(value = "Get all regions", nickname = "findAllRegions", response = Region.class)
    public List<Region> findAllRegions(){
        return service.findAllRegions();
    }
}
