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
class Solution {    //二叉树中序遍历+递归改迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();     //定义辅助栈
        while (root != null || !stk.empty()) {
            while (root != null){  //处理左子树
                stk.push(root);  
                root = root.left;  
            }

            //第一层while的root所有左子树处理完毕
            var t = stk.pop();
            res.add(t.val); //处理根
            root = t.right;  //处理右子树
        }

        return res;
    }
}
