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
class Solution {    //双指针算法一，不开额外空间，边界情况较多
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy1 = new ListNode(-200, list1), dummy2 = new ListNode(-200, list2);
        ListNode p1 = dummy1.next, p2 = dummy2;

        while (p1 != null && p2.next != null) {
            while (p2.next != null && p2.next.val <= p1.val) p2 = p2.next;
            p2.next = new ListNode(p1.val, p2.next);
            p2 = p2.next; p1 = p1.next;     //更新p1和p2
        }

        while (p1 != null) {
            p2.next = new ListNode(p1.val, null);
            p2 = p2.next; p1 = p1.next;
        }

        return dummy2.next;
    }
}