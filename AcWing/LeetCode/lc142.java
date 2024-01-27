package AcWing.LeetCode;        //142. 环形链表 II

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
public class Solution {     //快慢指针 + 数学推导 + 思维题
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode s = head, f = head;    //定义快慢指针
        while (f != null) {
            s = s.next; f = f.next;     //快慢指针分别向后走一步
            if (f == null) return null;
            f = f.next; //f再走一步
            if (s == f) {   //存在环
                s = head;   //s从起点走
                while (s != f) {
                    s = s.next; f = f.next; //s和f分别向后走一步，相遇时即为入口，数学推导
                }
                return s;
            }
        }

        return null;
    }
}
