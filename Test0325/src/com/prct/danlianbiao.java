package com.prct;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Maoch
 * Date: 2020-03-25
 * Time: 20:52
 */
class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class danlianbiao {
    public Node head;
    public danlianbiao(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.next = head.next;
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
        }

            cur.next = node;

    }
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        danlianbiao myLinklist = new danlianbiao();
        myLinklist.addFirst(3);
        myLinklist.addFirst(5);
        myLinklist.addFirst(7);
        myLinklist.addFirst(9);
        myLinklist.display();

    }
}
