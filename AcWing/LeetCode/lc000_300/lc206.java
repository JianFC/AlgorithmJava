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
class Solution { 
    public ListNode reverseList(ListNode head) {    //迭代写法 + 双指针 + 模板题
        if (head == null) return head;      //特判
        var a = head; var b = head.next;    //设置双指针
        while (b != null) {
            var t = b.next;     //暂存b.next
            b.next = a;     //反转a和b之间的连接
            a = b; b = t;   //a指针和b指针顺次往后移动
        }
        head.next = null;   //更新原头节点的next
        return a;   //最后a指针即指向反转后的头节点
    }

    public ListNode reverseList_2(ListNode head) {    //递归写法 + 隐式双指针
        if (head == null || head.next == null) return head;     //head为空or只有一个节点
        var tail = reverseList(head.next);  //递归对next进行反转
        head.next.next = head;  //将head和head -> next的节点的next反向
        head.next = null;   //更新head的next为空
        return tail;    //返回新的头节点
    }
}
