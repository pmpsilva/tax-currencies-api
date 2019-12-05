package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

}
