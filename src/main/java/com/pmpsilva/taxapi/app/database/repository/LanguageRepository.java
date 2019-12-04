package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository  extends JpaRepository<Language, Integer> {
}
