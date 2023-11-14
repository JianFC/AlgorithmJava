package AcWing.LeetCode;        //19. 删除链表的倒数第 N 个结点

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
class Solution {    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);    //虚拟头节点，防止边界问题

        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (n -- > 0) p1 = p1.next;   //p1领先p2 n步

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //此时p2的后一节点即为倒数第n个节点
        p2.next = p2.next.next;

        return dummy.next;
    }
}