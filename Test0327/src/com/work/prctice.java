package com.work;

/**
 * Created with IntelliJ IDEA
 * Description:单链表练习
 * User: Maoch
 * Date: 2020-03-27
 * Time: 20:23
 */
class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class prctice {
    public Node head;

    public prctice() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display1(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 反转一个单链表
     */
    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
     while (cur!=null){
         Node curNext = cur.next;
         if (curNext==null){
             newHead = cur;
         }
         cur.next = prev;
         prev = cur;
         cur = curNext;
     }
     return newHead;
    }

    /**
     *求中间节点
     */
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        prctice myLinklist = new prctice();
        myLinklist.addFirst(3);
        myLinklist.addFirst(5);
        myLinklist.addFirst(7);
        myLinklist.addFirst(9);
        myLinklist.addFirst(11);
        myLinklist.display();
       // myLinklist.reverseList();
        Node ret = myLinklist.middleNode();
        System.out.println(ret.data);
       //myLinklist.display1(ret);

    }
}
