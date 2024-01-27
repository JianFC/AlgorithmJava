package AcWing.LeetCode;        //103. 二叉树的锯齿形层序遍历

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
class Solution {    //BFS + 层序遍历 + 翻转
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        int cnt = 0;    //记录当前遍历的层是奇数层还是偶数层
        while (q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int len = q.size(); //当前层节点的个数
            while (len -- > 0) {
                var t = q.poll();
                level.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }

            if (++ cnt % 2 == 0) Collections.reverse(level); //偶数层，翻转
            res.add(level);
        } 

        return res;
    }
}
