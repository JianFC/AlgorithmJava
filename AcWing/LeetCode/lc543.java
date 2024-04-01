package AcWing.LeetCode;        //543. 二叉树的直径

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
class Solution {    //二叉树的直径 + LCA + 另一种方式ac1072 + 维护全局最优值
    int ans = 0;    //全局维护一个答案，存储最长路径

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {    //返回以root为跟往下走的路径边数最大值
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        ans = Math.max(ans, left + right);   //每次更新答案
        
        return Math.max(left, right) + 1;   //+1 为从root前一个节点走到root的一条边
    }
}