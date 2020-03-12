package net.work;
import java.util.Random;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int ret = max2(a,b);
        int ret1 =max3(a,b,c);
        System.out.println(ret);
        System.out.println(ret1);
    }
    public static int max2(int a,int b){
        return a >= b ? a : b;
    }
    public static int max3(int a,int b,int c){
        return max2((max2(a,b)),c);
    }
    //求阶乘
    public static int fac(int n){
        int ret = 1;
        for(int i = 1;i <= n;i++){
            ret = ret * i;
        }
        return ret;
    }
//阶乘之和
    public static int facSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int ret = 1;

            for (int j = 1; j <= i; j++) {
                ret = ret * j;

            }
            sum = sum + ret;
        }
        return sum;
    }


    //斐波那契数
   public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = fibo(n);
        System.out.println(ret);

    }

    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int ret = fibo(n - 1) + fibo(n - 2);
            return ret;
        }


    }

}



