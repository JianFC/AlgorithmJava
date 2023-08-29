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
class Solution {    //DFS+搜方案
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) dfs(root, sum);
        return res;
    }

    //sum表示root父节点的f(u)
    void dfs(TreeNode root, int sum) {
        path.add(root.val);     //将当前点加入path
        sum -= root.val;    //更新sum
        if (root.left == null && root.right == null) {  //root是叶节点
            if (sum == 0) res.add(new ArrayList(path));
        }
        else {
            if (root.left != null) dfs(root.left, sum);
            if (root.right != null) dfs(root.right, sum);
        }

        path.remove(path.size() - 1);   //恢复现场
    }
}
