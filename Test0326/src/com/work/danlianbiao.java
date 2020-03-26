package com.work;

import com.sun.org.apache.xalan.internal.lib.NodeInfo;

import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Maoch
 * Date: 2020-03-26
 * Time: 9:26
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

    public danlianbiao() {
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

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;

    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //求单链表长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        Node node = new Node(data);
        if (index < 0 || index > size()) {
            throw new RuntimeException("位置不合法！");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Node prev = findIndex(index);
        node.next = prev.next;
        prev.next = node;
    }

    private Node findIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找key是否在链表中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node findPrev(int key) {
        Node perv = this.head;
        while (perv.next != null) {
            if (perv.next.data == key) {
                return perv;
            }
            perv = perv.next;
        }
        return null;
    }

    //删除第一次出现key的节点
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = findPrev(key);
        if (prev == null) {
            System.out.println("没有这个节点！");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        //代表要删除的节点
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public void clear() {
        this.head = null;
    }



        public static void main(String[] args) {
            danlianbiao myLinklist = new danlianbiao();
            myLinklist.addFirst(3);
            myLinklist.addFirst(5);
            myLinklist.addFirst(7);
            myLinklist.addFirst(9);
            myLinklist.addFirst(9);
            myLinklist.removeAllKey(9);
            myLinklist.display();

        }


}
