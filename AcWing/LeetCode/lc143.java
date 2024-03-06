package AcWing.LeetCode;        //143. 重排链表

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
class Solution {    //链表 + 双指针 + 思维题
    public void reorderList(ListNode head) {
        if (head == null) return;
        int n = 0;
        for (var p = head; p != null; p = p.next) n ++;

        var mid = head;
        for (int i = 0; i < (n + 1) / 2 - 1; i ++) mid = mid.next;  //跳(n + 1) / 2 - 1下取整到中点
        
        ListNode a = mid, b = a.next;
        for (int i = 0; i < n / 2; i ++) {  //从中点后开始反转链表
            var c = b.next;
            b.next = a; a = b; b = c;
        }

        ListNode p = head, q = a;   //p节点从链表头开始，q节点从链表尾开始
        for (int i = 0; i < n / 2; i ++) {  //走n / 2次
            var c = q.next;
            q.next = p.next;    //q插到p的后面
            p.next = q;         //更新p的next
            p = q.next; q = c;  //更新p和q的位置
        }

        //处理尾节点
        if (n % 2 != 0) mid.next = null;
        else mid.next.next = null;
    }
}
