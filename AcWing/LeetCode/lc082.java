package AcWing.LeetCode;    //82. 删除排序链表中的重复元素 II

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
class Solution {    //双指针 + 模拟 + 思维题
    public ListNode deleteDuplicates(ListNode head) {
        var dummy = new ListNode(-1, head); //定义虚拟头节点
        var p = dummy;  //第一个指针，每次指向要判断重复结点的段的前一个结点
        while (p.next != null) {    //p的下一个结点存在(第二个指针，p的下一个结点)
            var q = p.next.next;    //第三个指针，q初始在p的下俩个结点
            while (q != null && q.val == p.next.val) q = q.next;    //不断将q向后移
            //注意null == null为true
            if (q == p.next.next) p = p.next;   //q没有移动，不存在重复元素，p移向下一个指针
            else p.next = q;     //删除重复段，注意此处不用更新p
        }

        return dummy.next;
    }
}
