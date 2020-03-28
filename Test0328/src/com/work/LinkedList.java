package com.work;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Maohc
 * Date: 2020-03-28
 * Time: 20:43
 */
class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    public Node head;

    public LinkedList() {
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
     *输入一个链表，输出该链表中倒数第k个结点
     */
    public Node findKthToTail(int k) {
        if(k <= 0 || this.head == null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        //1、让fast先走k-1步
        while (k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有改节点!");
                return null;
            }
        }
        //2、让两个引用 一起走  直到 fast.next == null
        // slow 所指的位置就是倒数第K个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     *以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
     */
    public Node partition(int x) {
        Node bs = null;
        Node be = null;//永远指向尾巴的地方
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    //第一个线段的第一次插入
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    //第一个线段的第一次插入
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个段没有数据
        if(bs == null) {
            //只能返回第二个段
            return as;
        }
        //代码走到这里 说明bs !=null  那么把两个段拼接起来
        be.next = as;
        //只要第二个段 不为空
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    public static void main(String[] args) {
        LinkedList myLinklist = new LinkedList();
        myLinklist.addFirst(3);
        myLinklist.addFirst(9);
        myLinklist.addFirst(7);
        myLinklist.addFirst(94);
        myLinklist.addFirst(11);
        myLinklist.display();
       Node cur = myLinklist.findKthToTail(3);
        System.out.println(cur.data);
       Node newHead = myLinklist.partition(7);
       myLinklist.display1(newHead);

    }
}




