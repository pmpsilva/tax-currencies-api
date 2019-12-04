package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Language;
import com.pmpsilva.taxapi.app.database.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageService {

    private final LanguageRepository repository;

    public List<Language> findAllLanguages(){
        return repository.findAll();
    }

}
