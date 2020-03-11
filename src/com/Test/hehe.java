package com.Test;
import java.util.Scanner;
import java.util.Random;
public class hehe {

    public static void main(String[] args){
        double sum = 0;
        int flg = 1;
        for(int i = 1;i <= 100;i++){
            sum = sum + 1.0/i * flg;
            flg = -flg;
        }
        System.out.print(sum);
    }
    public static void main10(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n < 0){
            System.out.print("-");
            n = -n;
        }
        while(n != 0){
            int tmp = n % 10;
            System.out.print(tmp);
            n = n / 10;
        }
    }
    public static void main9(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >>> 1;//输入为负数时
        }
        System.out.print(count);
    }
    public static void main8(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 31;i >= 1;i-=2){
            System.out.print(((n >>> i) & 1) + "" );
        }
        System.out.println();
        for(int i = 30;i >= 0;i -= 2){
            System.out.print(((n >>> i) & 1) + "" );
        }
    }
    public static void main7(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = a % b;
        while(c != 0){
            a = b;//a=16
            b = c;//b=8
            c = a % b;//c=0
        }
        System.out.println("最大公约数：" + b);
    }
    public static void main6(String[] args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100);
        //int num = scan.nextInt();
        while(true){
            System.out.println("输入你要输的数字：");
            int num = scan.nextInt();
            if(num < rand){
                System.out.println("小了！");
            }else if(num == rand){
                System.out.println("you win!");
                break;
            }else{
                System.out.println("大了!");
            }
        }

    }
    public static void main5(String[] args){
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        if(year <= 18){
            System.out.println(year + "是少年");
        }else if(year >= 19 && year <= 28){
            System.out.println(year + "是青年");
        }else if(year >= 29 && year <= 55){
            System.out.println(year + "是中年");
        }else{
            System.out.println(year + "是老年");
        }

    }
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        int n = scan.nextInt();
        for (i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                break;
            }
        }
        if (i >= n/2) {
           // i > n || i == n;

            System.out.println(n + "是素数");
        }
    }

    public static void main3(String[] args){
        int i;
        int j;
        for(i = 2;i <= 100;i++){
            for(j = 2;j < i;j++){
                if(i % j == 0)
                    break;
            }
            if(j >= i)
                System.out.println(i);
        }

    }
    public static void main2(String[] args){
        for(int year = 1000; year <= 2000;year++){
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                System.out.println(year);
            }
        }
    }
    public static void main1(String[] args){
        int i = 0;
        int count = 0;
        for(i = 1;i <= 100;i++){
            if(i % 10 == 9){
                count++;
            }
            if(i / 10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }

}
