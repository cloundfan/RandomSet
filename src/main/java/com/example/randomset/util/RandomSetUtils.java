package com.example.randomset.util;

import java.util.HashSet;
import java.util.Random;
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
    public static Set<Integer> randomSet1(int n, int m){
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
    public static int[] randomSet2(int n, int m){
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
    public static int[] randomSet3(int n, int m){
        int[] arrm = new int[m];
        int k = 0;
        int j = 0;
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


    /**
     * 使用交换数组位置的方法生成不重复随机数实现4
     *
     * @param n 随机数取值范围
     * @param m 生成不重复随机数个数
     * @return {@link int[]}
     */
    public static int[] randomSet4(int n, int m) {
        int[] readBall = new int[n];//红球号码池
        int[] userReadBall = new int[m];//用户选择的红球号码
        //为红球号码池赋值
        Random r= new Random();
        int index = -1;
        for(int i=0;i<userReadBall.length;i++) {
            index = r.nextInt(readBall.length-i);
            if(readBall[index] == 0){
                userReadBall[i] = index + 1;
//                int temp = index + 1;
                readBall[index] = readBall.length-i;
//                readBall[readBall.length-i-1] = index + 1;
            } else {
                userReadBall[i] = readBall[index];
//                int temp = readBall[index];
                readBall[index] = readBall.length-i;
//                readBall[readBall.length-i-1] = temp;
            }

        }
        return userReadBall;
    }
}
