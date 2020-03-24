package com.prac;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Maoch
 * Date: 2020-03-24
 * Time: 17:45
 */
public class shunxubiao {
    private int[] elem;
    private int useSize;
    //设置默认容量
    private static final int DEFAULT_SIZE = 3;

    public shunxubiao(){
        this.elem = new int[DEFAULT_SIZE];
        this.useSize = 0;
    }
    //打印顺序表
    public void display(){
        for (int i = 0; i < this.useSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    private void grow(){
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);

    }
    //在pos位置新增元素
    public void add(int pos,int data){
        if(isFull()){
           // System.out.println("顺序表是满的！");
           // return;
            //throw new RuntimeException("顺序表是满的");//异常
            grow();//扩容
        }
       checkPos(pos);
        //开始挪数据
        for (int i = this.useSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.useSize++;
    }
    public boolean isFull(){
        if(this.useSize == this.elem.length){
            return true;
        }
        return false;
    }
    //判断是否包含哪个元素
    public boolean contains(int toFind){
        if(isEmpty()){
            System.out.println("顺序表是空的！");
            return false;
           // throw new RuntimeException("顺序表是空的");
        }
        for (int i = 0; i < this.useSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(this.useSize == 0){
            return true;
        }
        return false;
    }
    //查找某个元素的位置
    public int search(int toFind){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空！");
        }
        for (int i = 0; i < this.useSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    private void checkPos(int pos){
        if(pos<0 || pos>this.useSize ){
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
    }
    //获取pos的位置
    public int getPos(int pos){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");
        }
        checkPos(pos);
        return this.elem[pos];
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        //调用search（）方法，看返回值-1若没有key，删除
        int index = search(key);
        if(index == -1){
            return;
        }
        for (int i = index; i < this.useSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.useSize--;
    }
    //获取顺序表长度
    public int size(){
        return this.useSize;
    }
    //清空顺序表
    public void clear(){
        this.useSize = 0;
    }

    public static void main(String[] args) {
        shunxubiao myArrayList = new shunxubiao();
        myArrayList.add(0,5);
        myArrayList.add(1,7);
        myArrayList.add(2,9);
        myArrayList.display();
        System.out.println("========grow=======");
        myArrayList.add(2,11);
        myArrayList.display();
        System.out.println(myArrayList.getPos(2));
        System.out.println("删除");
        myArrayList.remove(11);
        myArrayList.display();
        System.out.println("======clear======");
        myArrayList.clear();
        myArrayList.display();
    }
}
