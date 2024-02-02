package AcWing.LeetCode;        //39. 组合总和

class Solution {    //暴搜 + 找方案数
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();     //存储搜的路径

    public List<List<Integer>> combinationSum(int[] cs, int tg) {
        dfs(cs, 0, tg);

        return res;
    }

    void dfs(int[] cs, int u, int tg) {
        if (tg == 0) {
            res.add(new ArrayList(path)); //搜到一种合法方案，注意需要新建一个ArrayList！
            return;
        }

        if (u == cs.length) return;     //注意此行的位置，当所有数都枚举完

        //爆搜
        for (int i = 0; cs[u]*i <= tg; i ++) {
            dfs(cs, u + 1, tg - cs[u] * i);
            path.add(cs[u]);        //放在dfs之后保证i=0时不加入path
                                    //且cs[u]放入path的次数和i的次数相等
        }

        //注意恢复现场的位置
        for (int i = 0; cs[u] * i <= tg; i ++) path.remove(path.size() - 1);
    }
}    
