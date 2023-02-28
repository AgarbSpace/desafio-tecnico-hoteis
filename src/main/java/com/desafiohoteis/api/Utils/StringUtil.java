package com.desafiohoteis.api.Utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    
    private StringUtil() {
        throw new AssertionError();
    }

    public static boolean allNumbersAreEqual(String str) {
        if (!StringUtils.isNumeric(str)) {
            throw new IllegalArgumentException("Deve conter apenas caracteres numéricos");
        }

        char firstChar = str.charAt(0);
        String expected = StringUtils.repeat(firstChar, str.length());

        return str.equals(expected);
    }
}
