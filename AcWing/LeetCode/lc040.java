package AcWing.LeetCode;

class Solution {    //爆搜+找方案+排序
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] cs, int tg) {
        Arrays.sort(cs, 0, cs.length);  //排序保证相同的数相邻
        dfs(cs, 0, tg);

        return res;
    }

    void dfs(int[] cs, int u, int tg) {
        if (tg == 0) {
            res.add(new ArrayList(path)); 
            return;
        }

        if (u == cs.length) return;

        int k = u+1;
        while (k < cs.length && cs[k] == cs[u]) k++;
        int cnt = k-u;    //cnt表示cs[u]的可用个数

        for (int i = 0; i <= cnt && cs[u]*i <= tg; i++) {   //注意条件
            dfs(cs, k, tg - cs[u]*i);   //注意下一个dfs的位置是k
            path.add(cs[u]);
        }

        //恢复现场
        for (int i = 0; i <= cnt && cs[u]*i <= tg; i++) path.remove(path.size()-1);
    }
}