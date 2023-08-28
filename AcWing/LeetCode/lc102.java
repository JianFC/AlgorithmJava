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
class Solution {    //BFS+层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();     //BFS需要队列
        if (root != null) q.offer(root);    //加入队尾
        
        while (q.size() > 0) {  //BFS
            List<Integer> level = new ArrayList<>();    //存储每一层节点
            int len = q.size(); //该层节点数量

            while (len-- > 0) {   //遍历每一层
                var t = q.poll();   //取出队头
                level.add(t.val);   //存储每一层的信息
                if (t.left != null) q.offer(t.left);    //左儿子入队
                if (t.right != null) q.offer(t.right);   //右儿子入队
            }

            res.add(level); //存储每一层答案
        }

        return res;
    }
}
