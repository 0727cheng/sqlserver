package com.test.sqlserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlserverApplicationTests {

    @Test
    void contextLoads() {
        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");

        System.out.println(classpath);

    }

    //冒泡排序运算
    public void shortid(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[i]) {//  条件arr[j]>arr[i]  为正排序,反之为逆排序
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        index(arr);
    }

    //打印输出方法
    public void index(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        /**
         * 冒泡排序
         */
        int[] arr = {64, 12, 5, 8, 32};
        SqlserverApplicationTests tests = new SqlserverApplicationTests();
        tests.shortid(arr);
        /**
         * 位运算
         */
        int a = 10, b = 2;
        System.out.println(a & b);
        System.out.println(a ^ b);
        System.out.println(a | b);
        /**
         * 三元运算
         */
        int A, B, C;
        A = 2;
        B = 3;
        C = A > B ? 100 : 200;
        System.out.println(C);
        /**
         *
         */

    }
}
