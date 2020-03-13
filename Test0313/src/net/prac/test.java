package net.prac;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class test {
    /**
     * 汉诺塔问题
     * 将a上面的n个盘子经b移到c上
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        hanoid(n,'A','B','C');


    }


    public static void move(char a,char c) {
        System.out.print(a+"->"+c+" ");

    }
    public static void hanoid(int n,char a,char b,char c){
        if(n == 1){
            move(a,c);
            return;
        }
        //将a上面的n-1个盘子由c移到b上
        hanoid(n-1,a,c,b);
        //此时a底下的最大的盘子移到c上
        move(a,c);
        //将b上的n-1的盘子由a移到c上
        hanoid(n-1,b,a,c);
    }
    /**
     * 青蛙跳n记台阶问题
     *
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(jump(n));
    }
    public static int jump(int n){
        if(n == 1) {
            return 1;//当n=1时，青蛙的方法只有一种
        }else if(n == 2) {
            return 2;//当n=2时，青蛙的方法有2种，跳2次，或者跳2阶；
        }
        /**
         * 跳到n阶，首次跳一节的方法有jump（n-1）种，首次跳2阶的方法有jump（n-2）种，所以总共方法为两者相加；
         * 跳到n阶，只能从n-1或n-2阶向上跳，即跳到n-1的方法为jump（n-1），跳到n-2的方法为jump（n-2），所以跳到n阶为两者相加；
         */
        return jump(n-1) + jump(n-2);
    }
}
