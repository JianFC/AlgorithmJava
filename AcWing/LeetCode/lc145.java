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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || stk.size() > 0) {
            while (root != null) {
                res.add(root.val);
                stk.push(root);     //入栈
                root = root.right;  //走到右子树
            }   //按照根 -> 右 -> 左的顺序遍历
            
            root = stk.pop().left;  //走到左子树
        }

        Collections.reverse(res);   //逆转即为 左 -> 右 -> 根的顺序，即后序遍历
        return res;
    }
}