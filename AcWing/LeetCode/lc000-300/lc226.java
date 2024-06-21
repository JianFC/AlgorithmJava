package AcWing.LeetCode;    //226. 翻转二叉树

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
class Solution {    //模板题 + 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        var t = root.left; root.left = root.right; root.right = t;      //交换左右儿子
        invertTree(root.left);      //递归翻转左右子树
        invertTree(root.right);
        return root;    //返回根节点
    }
}