package AcWing.LeetCode;        //98. 验证二叉搜索树

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
class Solution {    //BST定义+DFS(返回数组)+模板题
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;    
        return dfs(root)[0] == 1? true: false;
    }

    //int[0] 表示root的子树是否合法，int[1]表示root子树中最小值，int[2]表示子树的最大值
    int[] dfs(TreeNode root) {
        //初始化答案
        int[] res = new int[]{1, root.val, root.val};
        if (root.left != null){     //递归处理左子树
            int[] t = dfs(root.left);
            if (t[0] == 0 || t[2] >= root.val) res[0] = 0;  //不合法
            res[1] = Math.min(res[1], t[1]);    //更新最小值
            res[2] = Math.max(res[2], t[2]);    //更新最大值
        }
        if (root.right != null) {   //递归处理右子树
            int[] t = dfs(root.right);
            if (t[0] == 0 || t[1] <= root.val) res[0] = 0;  //不合法
            res[1] = Math.min(res[1], t[1]);
            res[2] = Math.max(res[2], t[2]);
        }

        return res;
    }
}
