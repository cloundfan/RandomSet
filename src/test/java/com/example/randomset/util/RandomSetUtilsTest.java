package com.example.randomset.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

class RandomSetUtilsTest {
    private static final Logger LOGGER = getLogger(RandomSetUtilsTest.class);
    @Test
    void random1() {
        LOGGER.debug(RandomSetUtils.random1(33, 6).toString());
    }

    @Test
    void random2() {
        LOGGER.debug(Arrays.toString(RandomSetUtils.random2(33, 6)));
    }

    @Test
    void random3() {
        LOGGER.debug(Arrays.toString(RandomSetUtils.random3(33, 6)));
    }
}