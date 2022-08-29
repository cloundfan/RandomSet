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
     * @param n 随机数取值范围
     * @param m 生成不重复随机数个数
     * @return {@link Set}<{@link Integer}>
     */
    public static Set<Integer> random1(int n, int m){
        Set<Integer> set = new HashSet<Integer>();
        while(set.size()<m){
            set.add(ThreadLocalRandom.current().nextInt(n) + 1);
        }
        return set;
    }


    /**
     * 使用byte数组实现生成不重复随机数
     *
     * @param n 随机数取值范围
     * @param m 生成不重复随机数个数
     * @return {@link int[]}
     */
    public static int[] random2(int n, int m){
        byte[] arrn = new byte[n];
        int[] arrm = new int[m];
        int j = 0;
        while(j<m){
            int i = ThreadLocalRandom.current().nextInt(n);
            if (arrn[i] == 0){
                arrn[i] = 1;
                arrm[j++] = i+1;
            }
        }
        return arrm;
    }


    /**
     * 使用类似开放寻址方式生成不重复随机数实现3
     *
     * @param n 随机数取值范围
     * @param m 生成不重复随机数个数
     * @return {@link int[]}
     */
    public static int[] random3(int n, int m){
        int[] arrm = new int[m];
        int k = 0;
        int j = 0;
//        int i = ThreadLocalRandom.current().nextInt(n) + 1;
//        arrm[k]=i;
        while (j<m){
            int i = ThreadLocalRandom.current().nextInt(n) + 1;
            k = i % m;
            while(arrm[k]!=0 && arrm[k]!=i){
                k=++k%m;
            }
            arrm[k]=i;
            j++;
        }
        return arrm;
    }
}
