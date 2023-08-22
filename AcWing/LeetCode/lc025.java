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
class Solution {    //单指针+双指针
    public ListNode reverseKGroup(ListNode head, int k) {
        var dummy = new ListNode(-1, head);

        for (var p = dummy; ; ) {   //p单指针，每次向后移动k个位置，根据p的位置生成两个双指针
            var q = p;
            for (int i = 0; i < k && q != null; i++) q = q.next;  //判断p之后是否还有k个节点
            if (q == null) break;   //已经没有k个节点，结束

            var a = p.next; var b = a.next;
            for (int i = 0; i < k-1; i++) {     //交换k个节点内部节点，循环k-1次。a->b->c => a<-b<-c
                //a->b = > a<-b
                var c = b.next;     //先存下b后一个节点的信息
                b.next = a;         //更改连接方向
                //a.next = c;     //a指针next不需要更改，a的后继不是c！！
                a = b; b = c;    //分别将a指针和b指针向后移动一个位置        
            }

            //更新p单指针的信息和k个节点外部连接信息
            var c = p.next;     //存下p节点后继节点信息
            p.next = a;
            c.next = b; 
            p = c;      //更新p
        }

        return dummy.next;
    }
}