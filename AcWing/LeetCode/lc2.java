package AcWing.LeetCode;

public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);    //添加虚拟头节点，简化边界情况判断
        ListNode cur = res;
        int carry = 0;
        while (l1!=null || l2!=null || carry!=0) {
            int n1 = l1!=null? l1.val: 0;
            int n2 = l2!=null? l2.val: 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            
            int sum = n1+n2+carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum/10;
        }
        return res.next;
    }
}
