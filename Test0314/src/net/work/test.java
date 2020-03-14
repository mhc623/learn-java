package net.work;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int [] arr = new int [100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
           // System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        int[] arr = {1, 2, 3,};
        printArray(arr);
        System.out.print(Arrays.toString(arr));
    }
    public static void printArray(int [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("======");
    }
    public static void main3(String[] args) {
        int [] arr = {1,2,3,};
        transform(arr) ;
        System.out.print(Arrays.toString(arr));
    }
    public static void transform(int [] a){

        for (int i = 0;i < a.length; i++) {
           a [i] = a[i] * 2;
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("========");
    }
    public static void main2(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(sum(arr)) ;
    }
    public static int sum(int [] arr){
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret;
    }
    public static void main1(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(avg(arr)) ;


    }
    public static double avg(int [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }
        return (double)sum / (double)arr.length;


    }
}
