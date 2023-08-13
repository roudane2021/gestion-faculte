package com.gestion.service.application.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

public interface Utils {

    public static String generateRandomString(int size) {

        return RandomStringUtils.randomAlphabetic(size);
    }
}
