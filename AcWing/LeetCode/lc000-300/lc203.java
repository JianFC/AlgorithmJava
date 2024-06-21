package AcWing.LeetCode;        //203. 移除链表元素

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
class Solution {    //虚拟头节点 + 双指针
    public ListNode removeElements(ListNode head, int val) {
        var dummy = new ListNode(-1, head);     //定义虚拟头节点
        for (var p = dummy; p != null; p = p.next) {
            var q = p.next;     //双指针q跳过所有val的节点
            while (q != null && q.val == val) q = q.next;
            p.next = q;     //更新p的next指针
        }

        return dummy.next;  //返回头节点
    }
}
