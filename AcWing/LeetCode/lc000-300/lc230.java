package AcWing.LeetCode;        //230. 二叉搜索树中第K小的元素

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
class Solution {    //中序遍历 + BST性质 + 时O(k)
    int ans, k;    

    public int kthSmallest(TreeNode root, int _k) {
        k = _k;
        dfs(root);      //对BST进行中序遍历，找到BST中序遍历的第k个数
        return ans;
    }

    boolean dfs(TreeNode root) {
        if (root == null) return false;     //找到空节点，返回false
        if (dfs(root.left)) return true;        //如果左子树找到，返回true
        if (-- k == 0) {
            ans = root.val;     //找到了第k个数
            return true;    //直接返回，不用继续搜索
        }
        return dfs(root.right);     //继续在右子树搜索
    }
}