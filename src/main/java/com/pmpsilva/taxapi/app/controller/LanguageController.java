package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Language;
import com.pmpsilva.taxapi.app.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.LANG)
@AllArgsConstructor
public class LanguageController {

    private final LanguageService service;

    @GetMapping
    public List<Language> finAllLanguages(){
        return service.findAllLanguages();
    }
}
