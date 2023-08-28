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
    boolean ans = true; //存储答案，初始化为true

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {    //返回root为根的子树的最大深度
        if (root == null) return 0; //root为空，返回0
        int lh = dfs(root.left), rh = dfs(root.right);  //lh，左子树最大深度，右子树最大深度
        if (Math.abs(lh - rh) > 1) ans = false;     //不平衡
        return Math.max(lh, rh) + 1;    //返回当前子树深度最大值
    }
}
