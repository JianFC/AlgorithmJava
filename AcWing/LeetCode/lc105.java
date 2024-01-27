package AcWing.LeetCode;        //105. 从前序与中序遍历序列构造二叉树

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
class Solution {    //递归建树 + 模板题 + 数学推导
    Map<Integer, Integer> pos = new HashMap<>();    //映射位置哈希表，优化查找的值的位置的时间复杂度

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) pos.put(inorder[i], i);   //映射下标
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    //[pl, pr]为前序遍历的待构造区间，[il, ir]为中序遍历待构造的区间
    TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;   //区间已空
        var root = new TreeNode(preorder[pl]);  //前序遍历第一个点为root
        int k = pos.get(root.val);  //根据哈希表在中序遍历中找到root的位置
        root.left = build(preorder, inorder, pl + 1, pl + 1 + k - 1 - il, il, k - 1);   //build左子树
        root.right = build(preorder, inorder, pl + 1 + k - 1 - il + 1, pr, k + 1, ir);  //build右子树
        return root;
    }
}
