package com.work;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Maohc
 * Date: 2020-03-29
 * Time: 22:01
 */
class ListNode {
    public int val;
    public ListNode prev;//前驱
    public ListNode next;//后继

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {

    public ListNode head;//头

    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法！");
        }
    }

    private ListNode findIndex(int index) {
        ListNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        checkIndex(index);
        //0、index==0   || index == 长度
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        //1、先定义一个cur  走index布置
        ListNode cur = findIndex(index);
        //2、插入到index位置  改变4个值
        ListNode node = new ListNode(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                //当前cur是不是头结点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                //当前cur是不是头结点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
        this.last = null;
    }

    public static void main(String[] args) {
        LinkedList doubleLinkedList = new LinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.addFirst(0);

        doubleLinkedList.display();
        doubleLinkedList.addIndex(0, 6);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(3, 6);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(8, 6);
        doubleLinkedList.display();

        doubleLinkedList.removeAllKey(6);
        doubleLinkedList.display();


        doubleLinkedList.clear();
        System.out.println("hehe");
    }
}
