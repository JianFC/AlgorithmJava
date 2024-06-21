package AcWing.LeetCode;        //129. 求根节点到叶节点数字之和

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
class Solution {    //DFS + 维护信息
    int ans;    //存储答案

    public int sumNumbers(TreeNode root) {
        if (root != null) dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int number) {
        number = number * 10 + root.val;    //更新number;
        if (root.left == null && root.right == null) ans += number; //叶子节点
        if (root.left != null) dfs(root.left, number);  //递归左子树
        if (root.right != null) dfs(root.right, number);    //递归右子树
    }
}