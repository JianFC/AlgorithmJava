package AcWing.LeetCode;

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
class Solution {    //递归+模板题
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    //都为空，返回true
        if (p == null || q == null || p.val != q.val) return false;  //结构不一样or值不一样
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  //分别看左右子树
    }
}
