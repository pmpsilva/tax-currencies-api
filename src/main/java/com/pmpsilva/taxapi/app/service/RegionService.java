package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Region;
import com.pmpsilva.taxapi.app.database.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {
    private RegionRepository repository;

    public List<Region> findAllRegions(){
        return repository.findAll();
    }
}
