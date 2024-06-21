package AcWing.LeetCode;       // 147. 对链表进行插入排序

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
class Solution {    //插入排序 + 思维题 + 双指针
    public ListNode insertionSortList(ListNode head) {
        var dummy = new ListNode(-1);   //头节点可能会变，建立虚拟头节点
        for (var p = head; p != null; ) {     //遍历每个点
            var cur = dummy;        //cur代表已经排好序的链表的尾节点
            //每次找到排好序的链表中第一个大于p.val的节点
            while (cur.next != null && cur.next.val <= p.val) cur = cur.next;
            var next = p.next;      //先将p的next存储下来
            p.next = cur.next;      //将p插到cur之后
            cur.next = p;
            p = next;   //先把next存下来，方便更新p
        }

        return dummy.next;
    }
}
