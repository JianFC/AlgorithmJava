package AcWing.LeetCode;    // 106. 从中序与后序遍历序列构造二叉树

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
class Solution {    //递归建树 + 模板题
    Map<Integer, Integer> pos = new HashMap<>();    //位置映射，O(1)找下标

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) pos.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir) return null;   //区间空
        var root = new TreeNode(postorder[pr]);     //后序遍历最后一个点为root
        int k = pos.get(root.val);  //找到中序遍历中root的位置
        root.left = build(inorder, postorder, il, k - 1, pl, pl + k - 1 - il);  //build左子树
        root.right = build(inorder, postorder, k + 1, ir, pl + k - 1 - il + 1, pr - 1); //build右子树
        return root;
    }
}
