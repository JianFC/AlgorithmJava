package AcWing.LeetCode;        //86. 分隔链表

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
class Solution {    // 链表快排模板一部分 + 双指针思想 + 思维题
    public ListNode partition(ListNode head, int x) {
        var ld = new ListNode(-1); var rd = new ListNode(-1);   //左右链表的虚拟头节点
        var lt = ld; var rt = rd;   //左右链表的尾节点

        for (var p = head; p != null; p = p.next) {
            if (p.val < x) lt = lt.next = p;    //存到左链表中
            else rt = rt.next = p;  //存到右链表中
        }
        
        lt.next = rd.next;  //将右链表拼到左链表后
        rt.next = null; //更新右链表尾节点next为null

        return ld.next;
    }
}
