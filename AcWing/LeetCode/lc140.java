package AcWing.LeetCode;        //140. 单词拆分 II

class Solution {    //方案暴搜 + 预处理DP剪枝优化
    int N = 30;
    int n;
    List<String> ans = new ArrayList<>();
    Set<String> hash = new HashSet<>(); //哈希表
    boolean[] f = new boolean[N];       //f[i]表示si - sn能否被合法划分，用于暴搜剪枝

    public List<String> wordBreak(String s, List<String> wordDict) {
        n = s.length();
        for (var str: wordDict) hash.add(str);          //由于暴搜是指数级别复杂度，因此此处没有必要用字符串哈希
        f[n] = true;   //倒序预处理f[i ~ (n - 1)], f[n]边界，类似正序f[0]，初始化为true
        for (int i = n - 1; i >= 0; i --)   //枚举起点
            for (int j = i; j < n; j ++)    //枚举单词终点
                if (hash.contains(s.substring(i, j + 1)) && f[j + 1])
                    f[i] = true;
        
        dfs(s, 0, "");      //暴搜答案
        return ans;
    }

    void dfs(String s, int u, String path) {
        if (u == n) {
            path = path.substring(0, path.length() - 1);    //去掉最后一个空格
            ans.add(path);
        }
        else {
            for (int i = u; i < n; i ++) {  //枚举划分位置
                if (hash.contains(s.substring(u, i + 1)) && f[i + 1])
                    dfs(s, i + 1, path + s.substring(u, i + 1) + ' ');
            }
        }
    }
}
