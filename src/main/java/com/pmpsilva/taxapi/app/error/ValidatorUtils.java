package com.pmpsilva.taxapi.app.error;

import com.pmpsilva.taxapi.app.database.domain.Currency;
import com.pmpsilva.taxapi.app.database.domain.Language;

public class ValidatorUtils {

    public static boolean isValidCurrency(Currency currency) {
        if (currency != null) {
            if (currency.getSymbol() == null || currency.getSymbol() == null
                    || currency.getCode().isEmpty() || currency.getSymbol().isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidLanguage(Language language) {
        if (language != null) {
            if (language.getCode() == null || language.getLocalName() == null
                    || language.getCode().isEmpty() || language.getLocalName().isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
