package com.example.randomset.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生成不重复随机数
 *
 * @author FZH
 * @date 2022/08/30
 */
public class RandomSetUtils {
    /**
     * 使用Set集合实现生成不重复随机数
     *
     * @param randomRange 随机数范围
     * @param randomCount 随机数个数
     * @return {@link Set}<{@link Integer}>
     */
    public static Set<Integer> randomSet1(int randomRange, int randomCount){
        Set<Integer> randomCountsSet = new HashSet<Integer>();
        while(randomCountsSet.size() < randomCount){
            randomCountsSet.add(ThreadLocalRandom.current().nextInt(randomCount) + 1);
        }
        return randomCountsSet;
    }


    /**
     * 使用byte数组实现生成不重复随机数
     *
     * @param randomRange 随机数范围
     * @param randomCount 随机数个数
     * @return {@link int[]}
     */
    public static int[] randomSet2(int randomRange, int randomCount){
        byte[] randomRangeArr = new byte[randomRange];
        int[] randomCountArr = new int[randomCount];
        int randomCountIndex = 0;
        while(randomCountIndex < randomCount){
            int randomNum = ThreadLocalRandom.current().nextInt(randomRange);
            if (randomRangeArr[randomNum] == 0){
                randomRangeArr[randomNum] = 1;
                randomCountArr[randomCountIndex++] = randomNum + 1;
            }
        }
        return randomCountArr;
    }


    /**
     * 使用类似开放寻址方式生成不重复随机数实现3
     *
     * @param randomRange 随机数范围
     * @param randomCount 随机数个数
     * @return {@link int[]}
     */
    public static int[] randomSet3(int randomRange, int randomCount){
        int[] randomCountArr = new int[randomCount];
        int randomCountIndex = 0;
        while (randomCountIndex < randomCount){
            int randomNum = ThreadLocalRandom.current().nextInt(randomRange) + 1;
            int randomModulo = randomNum % randomCount;
            while(randomCountArr[randomModulo] != 0 && randomCountArr[randomModulo] != randomNum){
                randomModulo = ++randomModulo % randomCount;
            }
            randomCountArr[randomModulo] = randomNum;
            randomCountIndex++;
        }
        return randomCountArr;
    }


    /**
     * 使用交换数组位置的方法生成不重复随机数实现4
     *
     * @param randomRange 随机数范围
     * @param randomCount 随机数个数
     * @return {@link int[]}
     */
    public static int[] randomSet4(int randomRange, int randomCount) {
        int[] randomRangeArr = new int[randomRange];
        int[] randomCountArr = new int[randomCount];
        for(int i = 0; i < randomCountArr.length; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(randomRangeArr.length - i);
            if(randomRangeArr[randomNum] == 0){
                randomCountArr[i] = randomNum + 1;
                randomRangeArr[randomNum] = randomRangeArr.length - i;
            } else {
                randomCountArr[i] = randomRangeArr[randomNum];
                randomRangeArr[randomNum] = randomRangeArr.length - i;
            }
        }
        return randomCountArr;
    }
}
