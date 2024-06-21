package AcWing.LeetCode;    //LeetCode 83. 删除排序链表中的重复元素

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
class Solution {    //双指针 + 模拟 + 模板题
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        var cur = head; //cur代表去重链表的尾节点，初始将第一个结点加入（第一个指针）
        for (var p = cur.next; p != null; p = p.next) { //p第二个指针，从第二结点开始扫描链表
            if (p.val != cur.val)
                cur = cur.next = p;     //更新cur.next 和 cur本身
        }

        cur.next = null;    //更新去重指针尾节点的next

        return head;
    }
}
