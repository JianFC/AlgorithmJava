package AcWing.LeetCode;        //92. 反转链表 II

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
class Solution {    //链表三指针+模板题
    public ListNode reverseBetween(ListNode head, int n, int m) {
        var dummy = new ListNode(-1, head);
        var a = dummy;
        for (int i = 0; i < n - 1; i ++) a = a.next; //向后移动m-1次到达n前一个位置
        var b = a.next; var c = b.next; //b，c分别指向a后两个位置
        for (int i = 0; i < m - n; i ++) {   //中间翻转m-n次
            var t = c.next;
            c.next = b; //翻转b与c的链接
            b = c; c = t;   //将b与c分别向后移动一个位置
        }
        
        a.next.next = c;    //更新翻转链表外部的链接
        a.next = b;

        return dummy.next;
    }
}
