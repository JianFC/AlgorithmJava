package AcWing.LeetCode;    //LeetCode 437. 路径总和 III

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
class Solution {    //lc530扩展 + 哈希表 + 前缀和 + dfs + 时O(n)
    int res;    //存储的答案
    Map<Long, Integer> hash = new HashMap<>();   //存储每个区间终点前各前缀和值出现的次数，使用long防止溢出

    public int pathSum(TreeNode root, int sum) {
        hash.put(0L, 1);     //哨兵节点，初始将s[0] = 0加入哈希表中
        dfs(root, sum, 0);
        return res;
    }

    void dfs(TreeNode root, int sum, long cur) {
        if (root == null) return ;
        cur += root.val;    //更新枚举到的区间终点的前缀和值
        res += hash.getOrDefault(cur - sum, 0);     //类似lc560，维护答案
        hash.put(cur, hash.getOrDefault(cur, 0) + 1);       //更新哈希表
        
        dfs(root.left, sum, cur); dfs(root.right, sum, cur);        //递归搜索左右子树
        hash.put(cur, hash.get(cur) - 1);       //左右子树搜索完毕，将cur从哈希表中移除
    }
}
