package AcWing.LeetCode;        // 148. 排序链表

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
class Solution {    //递归归并排序写法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int n = 0;      //统计链表长度
        for (var p = head; p != null; p = p.next) n ++;
        int mid = n / 2;        
        
        ListNode ld = new ListNode(-1), rd = new ListNode(-1);      //lt左链表虚拟头节点，rd右链表虚拟头节点
        ListNode lt = ld, rt = rd;
        
        int k = 0;
        for (ListNode p = head; p != null; p = p.next, k ++) {
            if (k < mid) lt = lt.next = p;
            else rt = rt.next = p;
        }

        lt.next = null;
        ListNode lh = sortList(ld.next), rh = sortList(rd.next);    //分治
        lt = lh; rt = rh;

        ListNode td = new ListNode(-1), tail = td;      //合并后的虚拟头节点
        while (lt != null && rt != null) {
            if (lt.val <= rt.val) {
                tail = tail.next = lt; lt = lt.next;
            }
            else {
                tail = tail.next = rt; rt = rt.next;
            }
        }

        if (lt != null) tail.next = lt;
        if (rt != null) tail.next = rt;

        return td.next;
    }

}
