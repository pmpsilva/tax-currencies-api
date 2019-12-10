package com.pmpsilva.taxapi.app.controller;

import com.pmpsilva.taxapi.app.PathAPI;
import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.domain.Language;
import com.pmpsilva.taxapi.app.error.CustomException;
import com.pmpsilva.taxapi.app.error.ErrorCode;
import com.pmpsilva.taxapi.app.error.ValidatorUtils;
import com.pmpsilva.taxapi.app.service.LanguageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathAPI.LANG)
@AllArgsConstructor
@Api(value = "Language Controller",  tags = {"Language"})
public class LanguageController {

    private final LanguageService service;

    @GetMapping
    @ApiOperation(value = "Find All Languages", nickname = "findAllLanguages",
            response = Language.class)
    public List<Language> finAllLanguages(){
        return service.findAllLanguages();
    }

    @GetMapping(PathAPI.CODE)
    @ApiOperation(value = "Get Language by code (Iso 639-3 ex 'POR')", nickname = "findLanguageByCode",
            response = Language.class)
    public Language findLanguageByCode(@PathVariable("code") String code) throws CustomException {
        return service.findLanguageByCode(code);
    }

    @GetMapping(PathAPI.ENGLISH_NAME)
    @ApiOperation(value = "Get Language by english name (ex 'portuguese')", nickname = "findLanguageByEnglishName",
            response = Language.class)
    public Language findLanguageByEnglishName(@PathVariable("name") String name) throws CustomException {
        return service.findLanguageByEnglishName(name);
    }

    @GetMapping(PathAPI.LOCAL_NAME)
    @ApiOperation(value = "Get Language by local name (ex 'português')", nickname = "findLanguageByLocalName",
            response = Language.class)
    public Language findLanguageByLocalName(@PathVariable("name") String name) throws CustomException {
        return service.findLanguageByLocalName(name);
    }

    @PostMapping
    @ApiOperation(value = "Create new Language", nickname = "createLanguage")
    public Language create(
            @ApiParam(name = "Language details")
            @RequestBody Language language) throws CustomException {
        if (ValidatorUtils.isValidLanguage(language)) {
            return service.create(language);
        } else {
            throw new CustomException("Invalid Language Object",
                    new Throwable(String.valueOf(ErrorCode.INVALID_INPUT)));
        }
    }

}
