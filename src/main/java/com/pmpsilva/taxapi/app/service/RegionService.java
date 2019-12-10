package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Region;
import com.pmpsilva.taxapi.app.database.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RegionService {
    private RegionRepository repository;

    public List<Region> findAllRegions(){
        log.info("Find all regions called");
        return repository.findAll();
    }
}
