package AcWing.LeetCode;

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
class Solution {    //链表排序归并模板 + 迭代写法(时间O(nlogn)，空间O(1))
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (var p = head; p != null; p = p.next) n ++;     //链表长度

        var dummy = new ListNode(-1, head);     //归并排序每层头节点会变，故建立虚拟头节点
        for (int i = 1; i < n; i <<= 1) {  //从下网上迭代，枚举区间长度，每层区间长度是下一层的两倍
            var cur = dummy;    //每一层从dummy开始
            
            //每次枚举两个区间，当最后只有一个区间时，直接加入cur链表，即j + i <= n
            for (int j = 1; j + i <= n; j += i * 2) {   
                var p = cur.next; var q = p;    //定义两个指针，p指向第一个区间开头
                for (int k = 0; k < i; k ++) q = q.next;    //将q指向第二个区间开头
                int l = 0, r = 0;   //控制两个指针走的距离
                while (l < i && r < i && p != null && q != null) {  //两个区间归并过程，需要判断指针是否走到空
                    if (p.val <= q.val) {
                        cur = cur.next = p; p = p.next; l ++;
                    }
                    else {
                        cur = cur.next = q; q = q.next; r ++;
                    }
                }
                //处理剩余部分
                while (l < i && p != null) {
                    cur = cur.next = p; p = p.next; l ++;
                }
                while (r < i && q != null) {
                    cur = cur.next = q; q = q.next; r ++;
                }
                cur.next = q;   //此时q的位置即后面待处理的两个区间的起点
            }
        }

        return dummy.next;
    }
}
