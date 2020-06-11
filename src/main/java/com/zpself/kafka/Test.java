package com.zpself.kafka;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By ZengPeng
 * @Description
 * @date in  2020/6/11 12:17
 * @Modified By
 */
public class Test {
    public static void main(String[] args) {
        //fuonction_1();
        fuonction_2();
    }
    private static void fuonction_2() {
        //整数数组a,数组大小为n,整数b,判断a中有没有有两个元素的和等于b
        int[] a = {1,2,3,6,7,8};
        int b = 3;
        //1.创建一个Set集合，获取a集合中两两相加的值；数据量可能有点大----排列组合。
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int numb1 = a[i];
            for (int j = i+1; j < a.length; j++) {
                sumSet.add(numb1+a[j]);
            }
        }
        //2.判断b中的元素是否存在于set集合中
        if(sumSet.contains(b))
            System.out.println("存在");
        else
            System.out.println("不存在");
        //3.此实现的时间复杂度为：n*n   ,空间复杂度为：n*n
    }

    private static void fuonction_1() {
        //整数数组a,整数数组b,判断a中有没有有两个元素的和等于b中的元素
        int[] a = {1,2,3,6,7,8};
        int[] b = {5,8};
        //1.创建一个Set集合，获取a集合中两两相加的值；数据量可能有点大----排列组合。
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int numb1 = a[i];
            for (int j = i+1; j < a.length; j++) {
                sumSet.add(numb1+a[j]);
            }
        }
        //2.遍历b集合中的元素是否存在于set集合中
        //.....
    }
}
