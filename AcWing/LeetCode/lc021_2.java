package AcWing.LeetCode;        //21. 合并两个有序链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {    //双指针算法，额外多开n的空间，类似归并，边界简单
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), tail = dummy;    //tail指向链表尾部

        while (list1! = null && list2! = null) {
            if (list1.val < list2.val) {
                tail = tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail = tail.next = list2;
                list2 = list2.next;
            }
        }

        //清理剩余元素 因为是链表，所以可以不用循环
        if (list1 != null) tail = tail.next = list1; 
        if (list2 != null) tail = tail.next = list2; 
        

        return dummy.next;
    }
}

