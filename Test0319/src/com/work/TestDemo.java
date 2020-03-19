package com.work;

/**
 * Created with IntelliJ IDEA
 * Description:初识类与对象
 * User: Maohc
 * Date: 2020-03-19
 * Time: 18:26
 */
//声明一个类 Person  类--》对象（实体）
class Person{
    private String name;//属性    成员变量
    private int age;

    public String getName() {
        return name;
    }
  //alt+insert快捷键选择
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //行为-->方法
    public void eat(){
        System.out.println("吃饭！");
    }
    public void sleep(){
        System.out.println("睡觉！");
    }
    public void show(){
        System.out.println("name: "+name+"age: "+age );
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();//实例化对象 new关键字
        person.setName("张三");
        person.getAge();
        String name = person.getName();
        System.out.println(name);
        person.show();


    }
}
