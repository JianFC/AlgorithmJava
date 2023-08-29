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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;  //root是叶节点
        if (root.left != null && root.right != null) 
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1; //左右子树最小值+1
        if (root.left != null) return minDepth(root.left) + 1;  //左子树非空
        return minDepth(root.right) + 1;    //右子树非空
    }
}
