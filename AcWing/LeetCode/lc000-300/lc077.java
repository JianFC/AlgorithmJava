package AcWing.LeetCode;    //77. 组合

class Solution {    //DFS + 固定顺序去重(start) + 组合模板
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();     //存储路径


    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    //k代表还需要选几个数，start规定顺序，防止组合重复
    void dfs(int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList(path));
            return;
        }

        for (int i = start; i <= n; i ++) {
            path.add(i);
            dfs(n, k - 1, i + 1);
            path.remove(path.size() - 1);   //恢复现场
        }
    }
}
