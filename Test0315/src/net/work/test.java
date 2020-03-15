package net.work;

import java.util.Arrays;

public class test {
    /**
     * 判断数组是否有序
     */
    public static void main(String[] args) {
        int [] arr = {1,5,2,18,10,3};
        System.out.println(isSored(arr));

    }
    public static boolean isSored(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                return false;
            }
            //return true;
        }
        return true;
    }
    /**
     *数组的冒泡排序
     */
    public static void main3(String[] args) {
        int [] arr = {1,5,2,18,10,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int [] arr){
        boolean flg = false;
        for(int i = 0;i < arr.length-1;i++){
            flg = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                return;
            }
        }
    }

    /**
     *数组的逆序
     */
    public static void main2(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        retu(arr);

        System.out.println(Arrays.toString(arr));
    }
    public static void retu(int [] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     *数组的二分查找
     */

    public static void main1(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr,4));
    }
    public static int binarySearch(int [] arr, int key){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(key < arr[mid]){
                right = mid - 1;
            }else if(key > arr[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
          //  return mid;
        }
        return -1;
    }

}
