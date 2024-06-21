package AcWing.LeetCode;    //199. 二叉树的右视图

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
class Solution {    //二叉树的层序遍历 + BFS + 时O(n)
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();     //BFS队列
        List<Integer> res = new ArrayList<>();      //答案列表
        if (root == null) return res;   //空二叉树
        q.offer(root);   //根节点入队
        while (q.size() > 0) {
            int len = q.size();     //该层的节点数量
            for (int i = 0; i < len; i ++) {    //遍历该层所有节点
                var t = q.poll();   //出队并获取队头元素
                if (t.left != null) q.offer(t.left);     //左儿子入队
                if (t.right != null) q.offer(t.right);   //右儿子入队
                if (i == len - 1) res.add(t.val);   //找到该层最右侧节点
            }
        }

        return res;
    }
}
