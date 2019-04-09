package com.leetCode.algorithm;


import javafx.beans.binding.When;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.sound.midi.Soundbank;

/**
 * 一个链表类
 */
public class Link {

   public Entry head;
   public Link() {
       head = new Entry();
   }

    class Entry {
        int data;
        Entry next;
        public Entry (int val) { // //其他结点所需的构造函数
            data = val;
        }

        public Entry(){//将头结点初始化为  data=-1   next=null
            data = -1;
        }
    }

    /**
     * 头插法
     * @param val
     */
    public void insertHead(int val) {

        Entry curr = new Entry(val);
        curr.next = head.next;
        head.next = curr;
    }

    /**
     * 尾插法
     */
    public void insertFoot(int val) {

        Entry tmp;
        Entry curr = new Entry(val);
        tmp = head;

        while (tmp.next != null) {

            tmp = tmp.next;
        }
        tmp.next = curr;
        curr.next = null;

    }

    /**
     * 插入指定位置
     */
    public boolean insetAny (int post, int val) {

        if (post < 0 || post > getLength()) {
            return false;
        } else {
            Entry curr = head;
            // post位置
            for (int i = 0; i <= post; i++) {
                curr = curr.next;
            }
            Entry entry = new Entry(val);
            //插入
            entry.next = curr.next;
            curr.next = entry;

            return true;
        }
    }

    /**
     * 获得链表长度
     * @return
     */
    public int getLength() {

        int len = 0;

        Entry tmp;
        tmp = head.next;
        while (tmp != null){

            len ++;
            tmp = tmp.next;
        }
        return len;
    }

    /**
     * 链表打印
     */
    public void show() {
        Entry  tmp;
        tmp = head;
        //遍历
        while (tmp != null) {
            System.out.println("data:" + tmp.next.data);
            tmp = tmp.next;
        }
    }

    /**
     * 链表的逆置
     * head
     * -1          1         2           3
     *                                  null
     *  pre ->  entry ->  entry1->
     *
     *                              newHead
     * -1          1         2           3
     * null
     *  pre <- entry <-  entry1  <-
     *
     **/
    public Entry reserver() {
        Entry newHead; //尾节点
        Entry pre = head; //前置节点
        Entry entry = pre.next;
        pre.next = null;

        while (entry.next != null) {
            Entry entry1 = entry.next;
            entry.next = pre;
            pre = entry;
            entry = entry1;
        }
        entry.next = pre;
        //这时entry就是原来链表的最后一个结点，也就是新链表的头结点
        newHead = entry;
        return newHead;
    }

    /**
     * 倒数第k个节点
     */
    public void lastK(int len, int k) {

        Entry tmp;
        tmp = head;
        if (k < 0 || k > len) {
            System.out.println("超出长度");
        } else {
            for (int i = 0; i < len -k; i++) {
                tmp = tmp.next;
            }
        }
        System.out.println(tmp.data);
    }

    public int newK (int k) {
        if (k>0 || k < getLength()) {
            return -1;
        } else {
            Entry cur1, cur2;
            cur1 = head;
            cur2 = head;

            while (k-1>0) {
                if (null != cur2.next) {
                    cur2 = cur2.next;
                    k--;
                } else {
                    return -1;
                }
            }

            while (null != cur2.next) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1.data;
        }
    }
}
