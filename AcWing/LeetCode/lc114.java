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
class Solution {    //迭代+思维题
    public void flatten(TreeNode root) {
        while (root != null) {
            var p = root.left;  //先走到左子树
            if (p != null) {    //左子树存在
                while (p.right != null) p = p.right;    //找到左儿子右链末尾
                p.right = root.right;
                root.right = root.left; //将左儿子及左儿子右链插入右儿子
                root.left = null;
            }
            root = root.right;  //走到右儿子
        }
    }
}
