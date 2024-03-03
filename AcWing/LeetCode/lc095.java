package AcWing.LeetCode;        //95. 不同的二叉搜索树 II

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
class Solution {    //暴搜 + 枚举根节点 + catalan数 + 模板题
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    List<TreeNode> dfs(int l, int r) {
        List<TreeNode> res = new ArrayList<>(); //存储以[l, r]区间中每个数为根的二叉树的根节点root
        if (l > r) {
            res.add(null);  //没有合法结点，注意此句不能省
            return res;
        }

        for (int i = l; i <= r; i ++) {  //枚举该子树的root
            //递归生成左右子树部分的集合
            var left = dfs(l, i - 1); var right = dfs(i + 1, r);
            for (var ln: left)   //枚举左子树根节点
                for (var rn: right) {    //枚举右子树根节点
                    var root = new TreeNode(i);  //以i为根，注意每次要新建root，防止读写冲突
                    root.left = ln; root.right = rn;  //更新root的左右子树根节点
                    res.add(root);  //更新res
                }
        }

        return res;
    }
} 