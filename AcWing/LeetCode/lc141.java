package AcWing.LeetCode;        //141. 环形链表

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {     //双指针之快慢指针问题
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;    //链表为空or只有一个点
        ListNode s = head, f = head;   //s和f分别为慢指针和快指针
        while (f != null) {
            s = s.next; f = f.next; //快慢指针分别走一步
            if (f == null) return false;    //走到null，没有环
            f = f.next; //快指针再走一步
            if (s == f) return true;    //快慢指针相遇，存在环，返回true
        }

        return false;
    }
}
