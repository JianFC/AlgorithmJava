package AcWing.LeetCode;        //235. 二叉搜索树的最近公共祖先

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {    //LCA + BST性质优化 + 模板题 + 时O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            var t = p; p = q; q = t;    //交换p和q，使p.val <= q.val，从而根据BST的性质优化
        }
        
        if (p.val <= root.val && q.val >= root.val) return root;    //第一种情况，p和q位于root的左右两边，root为LCA
                //注意使用>= 和 <= ,当p和q位于root时，一起处理掉
        if (q.val < root.val) return lowestCommonAncestor(root.left, p, q);     //第二种情况，LCA位于左子树
        return lowestCommonAncestor(root.right, p, q);      //由于一定有解，第三种情况，LCA位于右子树
    }
}