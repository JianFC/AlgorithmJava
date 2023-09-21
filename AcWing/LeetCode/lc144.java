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
class Solution {    //模板题 + 辅助栈
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();    //定义辅助栈
        while (root != null || stk.size() > 0) {
            while (root != null) {  //循环内处理左子树
                res.add(root.val);  //先遍历根节点
                stk.push(root);     //入栈
                root = root.left;
            }   //左子树处理完毕

            root = stk.pop().right; //处理右子树
        }

        return res;
    }
}
