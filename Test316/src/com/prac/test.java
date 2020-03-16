package com.prac;

import java.util.Arrays;

public class test {
    /**
     *冒泡排序
     */
    public static void main(String[] args) {
        int [] arr = {1,5,4,45,2,65};
        mpSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mpSort(int [] arr){
        int tmp = 0; //定义一个临时变量
        for (int i = 0; i < arr.length ; i++) { //遍历数组，用i为下标；
            for (int j = 0; j < arr.length-1-i ; j++) { //对于每一个数组元素，把最大的数字放在后面
                if(arr[j] > arr[j+1]){ // 判断当前数字与后面数字大小
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; //用tmp进行交换
                }
            }
        }
    }
    /**
     *打印10000以内的回文数字，如2552
     */
    public static void main2(String[] args) {
        for (int i = 10; i <9999 ; i++) {
            if(retNum(i)){
                System.out.println(i);
            }

        }
    }
    public static boolean retNum(int num){
        int num1 = num; //保存初值；
        int tmp = 0; //设置返过来值初值为0；
        while(num > 0){
            tmp = tmp * 10 + num % 10;//得到一位数字；
            num /= 10;    //num减少一位
        }
        return tmp == num1;
    }
    /**
     *打印1~100之间的素数
     */
    public static void main1(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            if(Prime(i)){     //判断是否为素数；
                System.out.println(i);//打印素数；
            }

        }
    }
    public static boolean Prime(int num){
        if(num == 1){
            return false; //1不是素数，直接返回false；
        }
        long sprtNum = (long) Math.sqrt(num);//定义sprtNum为num的2次根；
        for (int i = 2; i <= sprtNum ; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
