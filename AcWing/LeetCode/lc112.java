package AcWing.LeetCode;        //112. 路径总和

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
class Solution {    //递归+从上往下搜索
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false; //空节点，返回false
        sum -= root.val;    //更新sum = sum - 从树根到root点的权值之和
        if (root.left == null && root.right == null) return sum == 0;   //到达叶节点
        return root.left != null && hasPathSum(root.left, sum) || root.right != null && hasPathSum(root.right, sum);    //左子树中存在路径or右子树中存在路径
    }
}
