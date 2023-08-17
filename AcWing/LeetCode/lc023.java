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
class Solution {    //k路归并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        //创建小根堆，利用堆来维护k个指针
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        for (ListNode ln: lists) if (ln != null) heap.offer(ln);    //初始入堆

        //k路归并，使用堆能保证所有元素全部进入链表，不再循环结束需要手动判断
        //时间复杂度O(nlogk)，n是链表总长度，k是指针个数，堆中元素最多为k个。
        while (!heap.isEmpty()) {
            ListNode ln = heap.poll();  //取出k个指针最小元素
            tail = tail.next = ln;  //放入临时链表

            if (ln.next != null) heap.offer(ln.next);   //下一个指针入堆
        }

        return dummy.next;
    }
}