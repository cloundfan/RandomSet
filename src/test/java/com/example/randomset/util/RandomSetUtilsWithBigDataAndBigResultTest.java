package com.example.randomset.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 生成不重复随机数测试类
 *
 * @author FZH
 * @date 2022/08/30
 */
class RandomSetUtilsWithBigDataAndBigResultTest {
    private static final Logger LOGGER = getLogger(RandomSetUtilsWithBigDataAndBigResultTest.class);

    /**
     * 使用Set集合实现生成不重复随机数
     */
    @Test
    void randomSet1() {
        LOGGER.debug(RandomSetUtils.randomSet1(100000000, 100000).toString());
    }

    /**
     * 使用byte数组实现生成不重复随机数
     */
    @Test
    void randomSet2() {
        LOGGER.debug(Arrays.toString(RandomSetUtils.randomSet2(100000000, 100000)));
    }

    /**
     * 使用类似开放寻址方式生成不重复随机数实现3
     */
    @Test
    void randomSet3() {
        LOGGER.debug(Arrays.toString(RandomSetUtils.randomSet3(100000000, 100000)));
    }

    @Test
    void randomSet4() {
        LOGGER.debug(Arrays.toString(RandomSetUtils.randomSet4(100000000, 100000)));
    }
}