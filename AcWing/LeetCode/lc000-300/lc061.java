package AcWing.LeetCode;        //61. 旋转链表

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
class Solution {    //模拟 + 思维题
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;  //特判
        int n = 0;      //存储链表总节点数
        ListNode tail = null;   //存储链表尾结点
        for (var p = head; p != null; p = p.next) {
            tail = p;
            n ++;
        }
        k %= n;     //将k限制在[0, n - 1]之间，因为旋转n次等价于不做任何操作
        if (k == 0) return head;

        var p = head;
        for (int i = 0; i < n - k - 1; i ++) p = p.next;     //跳n - k - 1次，p存储第n - k个节点
        tail.next = head;   //画图理解
        head = p.next;
        p.next = null;

        return head;
    }
}
