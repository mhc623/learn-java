package com.work;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description: java练习
 * User: maohc
 * Date: 2020-03-17
 * Time: 13:45
 */
public class test {
    /**
     *二维数组
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}};
        for (int[] i : arr) {
            for (int j : i) {
                if(j == i.length) {
                    System.out.print(j+",");
                }else{
                    System.out.print(j);
                }

            }
        }
    }
    public static void main2(String[] args) {
        int [] [] arr = new int [2][3];
        int [] [] arr1 = new int [] []{{1,2,3},{4,5,6}};
        int [][] arr2 = new int [][]{{1,2},{3,4},{5,6}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.println(arr2[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arr2));
    }
    public static void main1(String[] args) {
        int [] [] arr = new int [2][];
        arr[0] = new int []{1,2,3};
        arr[1] = new int []{4,5,6,7,8};
        System.out.println(Arrays.deepToString(arr));//利用Arrays.deep.ToString()打印

    }
}
