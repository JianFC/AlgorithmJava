package AcWing.LeetCode;        //24. 两两交换链表中的节点

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
class Solution {    //双指针变形：单指针 + 双指针
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);

        //从虚拟头节点开始便利，每次需要p节点后俩个节点（俩指针a, b）,且利用了&&的短路性质
        for (var p = dummy; p.next != null && p.next.next != null; ) {      //p节点表示要交换的两个节点的前一个位置
            var a = p.next; var b = a.next;
            p.next = b;     //画图理解
            a.next = b.next;
            b.next = a;
            p = a;  //更新p，循环条件中省略
        }

        return dummy.next;
    }
}
