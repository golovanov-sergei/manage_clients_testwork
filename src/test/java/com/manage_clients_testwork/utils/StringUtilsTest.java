package com.manage_clients_testwork.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isEmpty() {
        Assertions.assertTrue(StringUtils.isEmpty(""));
        Assertions.assertFalse(StringUtils.isEmpty(" "));
    }

    @Test
    void emailNotValid() {
        Assertions.assertTrue(StringUtils.emailNotValid("@mail."));
        Assertions.assertFalse(StringUtils.isEmpty("admin@email.com"));

    }

    @Test
    void phoneNotValid() {
        Assertions.assertTrue(StringUtils.phoneNotValid("9788590509"));
        Assertions.assertFalse(StringUtils.phoneNotValid("+79788590509"));

    }
}