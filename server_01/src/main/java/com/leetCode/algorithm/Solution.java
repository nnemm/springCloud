package com.leetCode.algorithm;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Solution {

   /* 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode curr = node;
        int carry = 0;
        while (null != l1 || null != l2) {

            int x = (null != l1) ? l1.val : 0;
            int y = (null != l2) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (null != l1)  l1 = l1.next;
            if (null != l2)  l2 = l2.next;
        }
        if (carry > 0) {

            curr.next = new ListNode(carry);
        }

        return node.next;
    }


    /**
     * 增加节点操作
     * @param
     */
    public void  addNode(ListNode node) {

    }


    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode l1 = new ListNode(4);
        l1.val = 5;
        l1.val = 6;
        System.out.println(l1.val);
    }
}
