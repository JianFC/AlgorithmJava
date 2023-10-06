package AcWing.LeetCode;
//124. 二叉树中的最大路径和

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
class Solution {    //枚举路径最高点(LCA思想)+维护f(u)+模板题
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;    //初始化ans
        dfs(root);
        
        return ans;
    }

    int dfs(TreeNode u) {   //返回值f(u)代表在u根子树中以u为起点的路径权值最大值
        if (u == null) return 0;
        int left = Math.max(0, dfs(u.left)), right = Math.max(0, dfs(u.right));   //递归求出左右子树f()
        ans = Math.max(ans, u.val + left + right);  //更新ans
        return u.val + Math.max(left, right);   //返回f(u)
    }
}
