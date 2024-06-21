package AcWing.LeetCode;        //104. 二叉树的最大深度

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
class Solution {    //DFS or BFS+模板题
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;     //root为空，直接返回0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; //否则返回左右子树最大值+1
    }
}
