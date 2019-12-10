package com.pmpsilva.taxapi.app.service;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.domain.Language;
import com.pmpsilva.taxapi.app.database.repository.LanguageRepository;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LanguageService {

    private final LanguageRepository repository;

    public List<Language> findAllLanguages() {
        log.info("Find All languages called");
        return repository.findAll();
    }

    public Language findLanguageByCode(String code) throws CustomException {
        log.info("Find language by code: {}", code);
        return repository.findLanguageByCodeIgnoreCase(code)
                .orElseThrow(() -> {
                    log.error("Can't find any language for code {}", code);
                    return new CustomException("Language not found for code " + code,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Language findLanguageByEnglishName(String englishName) throws CustomException {
        log.info("Find language by englishName: {}", englishName);
        return repository.findLanguageByEnglishNameIgnoreCase(englishName)
                .orElseThrow(() ->{
                    log.error("Can't find any language for  englishName {}", englishName);
                    return new CustomException("Language not found for name " + englishName,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Language findLanguageByLocalName(String localName) throws CustomException {
        log.info("Find language by localName: {}", localName);
        return repository.findLanguageByLocalNameIgnoreCase(localName)
                .orElseThrow(() ->{
                    log.error("Can't find any language for localName {}", localName);
                    return new CustomException("Language not found for name " + localName,
                            new Throwable(String.valueOf(ErrorCode.ENTITY_NOT_FOUND)));
                });
    }

    public Language create(Language language) throws CustomException {
        try {
            return repository.save(language);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("Can't create the Language " + language.getCode(), e.getMostSpecificCause());
        } catch (Exception e) {
            throw new CustomException("Can't create the Language " + language.getCode(), e.getCause());
        }

    }

}
