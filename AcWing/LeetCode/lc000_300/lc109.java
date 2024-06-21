package AcWing.LeetCode;        //109. 有序链表转换二叉搜索树

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {    //链表建树 + 递归 + 模板题
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int n = 0;  //存储链表中节点个数
        for (var p = head; p != null; p = p.next) n ++;
        if (n == 1) return new TreeNode(head.val);      //只有一个元素时，直接返回
        
        var cur = head;         //找到当前链表 中点 的前一个点，左子树(n - 1) / 2上取整，保证左子树始终有元素
        for (int i = 0; i < n / 2 - 1; i ++) cur = cur.next;    //找到中点前一个点
        var root = new TreeNode(cur.next.val);          //建立root节点
        root.right = sortedListToBST(cur.next.next);    //建立右子树
        cur.next = null;                                //更新左区间，最后一个点next置null
        root.left = sortedListToBST(head);              //建立左子树
        return root;
    }
}
