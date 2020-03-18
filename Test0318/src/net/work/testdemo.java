package net.work;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:java practice复制打印数组的四种方法；
 * User: Maoch
 * Date: 2020-03-18
 * Time: 21:37
 */
public class testdemo {
    /**
     *自定义打出带[]的数组
     */
    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9};
        System.out.println(Arrays.toString(arr));
        System.out.println(myString(arr));
    }
    public static String myString(int[] arr){
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ",";
            }

        }
        ret += "]";
        return ret;
    }
    /**
     * 方法4：clone()
     */
    public static void main4(String[] args) {
        int [] arr = {1,3,5,7,9};
        int[] ret = arr.clone();
        System.out.println(Arrays.toString(ret));
    }
    /**
     * 方法3：System.arraycopy
     */
    public static void main3(String[] args) {
        int [] arr = {1,3,5,7,9};
        int [] dest = new int [arr.length];
        System.arraycopy(arr,0,dest,0,arr.length);
        System.out.println("dest"+Arrays.toString(dest));
    }
    /**
     * 方法2:Arrrays.copfOf(int[] original,int newlength);
     */
    public static void main2(String[] args) {
        int [] arr = {1,3,5,7,9};
        int [] ret = Arrays.copyOf(arr,arr.length);
        System.out.println("ret: "+Arrays.toString(ret));
    }
    /**
     * 数组的拷贝方法1：利用for循环
     */
    public static void main1(String[] args) {
        int [] arr = {1,5,9,11,13};
        copyArr(arr);
        System.out.println("拷贝 arr ： " + Arrays.toString(arr));
    }
    public static int [] copyArr(int[] arr){
        int [] arr1 = new int [arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];

        }
        return arr1;
    }
}
