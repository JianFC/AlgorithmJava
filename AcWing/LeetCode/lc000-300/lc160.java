package AcWing.LeetCode;        //160. 相交链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {     //链表 + 模板题 + 思维题 + 时O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {    //最终p和q一定会相等，且相遇处即为两链表交点，不相交也能处理
            p = p != null ? p.next : headB;     //当p走到末尾时，从b链表开始走
            q = q != null ? q.next : headA;     //当q走到末尾时，从a链表开始走
        } 

        return p;
    }
}
