package com.pmpsilva.taxapi.app.database.repository;

import com.pmpsilva.taxapi.app.database.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Optional<Language> findLanguageByCodeIgnoreCase(String code);

    Optional<Language> findLanguageByEnglishNameIgnoreCase(String englishName);

    Optional<Language> findLanguageByLocalNameIgnoreCase(String localName);
}
