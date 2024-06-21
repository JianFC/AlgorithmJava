package AcWing.LeetCode;        //107. 二叉树的层序遍历 II

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
class Solution {    //BFS + 模板题
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();     //当前层节点的个数
            
            while (len -- > 0) {
                var t = q.poll();
                level.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }

            res.add(level);
        }

        Collections.reverse(res);   //翻转res，自底向上
        return res;
    }
}
