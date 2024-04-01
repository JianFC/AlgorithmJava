package AcWing.LeetCode;        //234. 回文链表

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
class Solution {    //翻转链表 + 时O(n) + 空O(1)
    public boolean isPalindrome(ListNode head) {
        int n = 0;      //统计链表元素数量
        for (var p = head; p != null; p = p.next) n ++;
        if (n == 1) return true;

        int half = n / 2;   //将后half个节点进行翻转
        var a = head;
        for (int i = 0; i < n - half; i ++) a = a.next;     //a指针跳n - half次到后半段开头
        var b = a.next;     //设置a，b双指针翻转后半段
        for (int i = 0; i < half - 1; i ++) {       //翻转half - 1次
            var c = b.next;
            b.next = a;     //翻转链表
            a = b; b = c;   //a和b指针向后走
        }

        var p = head; var q = a;   //q指针指向链表开头，q指针指向后半段反转后的开头，也即a
        boolean res = true;    //存储结果
        for (int i = 0; i < half; i ++) {   //比较half次
            if (p.val != q.val) {
                res = false;    //不是回文链表
                break;
            }

            p = p.next; q = q.next;     //移动两个指针
        }

        //恢复链表
        var tail = a;   //存储原链表的尾节点
        b = a.next;
        for (int i = 0; i < half - 1; i ++) {
            var c = b.next;
            b.next = a;
            a = b; b = c;
        }

        tail.next = null;   //恢复原链表的尾节点next
        return res;
    }
}