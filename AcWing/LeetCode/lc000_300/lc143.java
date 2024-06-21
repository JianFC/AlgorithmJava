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
        int n = 0;         //链表长度
        for (var p = head; p != null; p = p.next) n ++;

        var mid = head;     //跳到中点位置，即ceil(n / 2) == (n + 1) / 2的点，mid暂存中点节点，便于后面处理尾节点
        for (int i = 0; i < (n + 1) / 2 - 1; i ++) mid = mid.next;  //跳(n + 1) / 2 - 1步，到中点ceil(n / 2);
        
        ListNode a = mid, b = a.next;    //中点后面还有floor(n / 2) == n / 2个点，将后面部分点的next指针反转 n / 2次
        for (int i = 0; i < n / 2; i ++) {  //从中点后开始反转链表next指针
            var c = b.next;
            b.next = a; a = b; b = c;
        }       //完成反转之后，a号指针走到尾节点

        ListNode p = head, q =  a;   //p节点从第一部分链表头开始，q节点从第二部分链表尾开始
        for (int i = 0; i < n / 2; i ++) {          //需要交错n / 2次，
            var o = q.next;
            q.next = p.next;        //q插到p的后面
            p.next = q;         //更新p的next 
            p = q.next; q = o;  //更新p和q的位置
        }

        //最后处理尾节点，（todo：放前面可能死循环，思考为什么）
        if (n % 2 != 0) mid.next = null;       //总共奇数个点，中间有孤立点
        else mid.next.next = null;          //偶数个点，mid后还有一个点，需要next的next为空
    }
}
