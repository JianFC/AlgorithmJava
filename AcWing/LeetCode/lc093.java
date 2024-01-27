package AcWing.LeetCode;        //93. 复原 IP 地址

class Solution {    //DFS + 暴搜 + 剪枝
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");

        return res;
    }

    //u表示当前搜到了第几位，k表示搜到了几个数(一共搜4个数[0-3])
    void dfs(String s, int u, int k, String path) {
        if (u == s.length()) {
            if (k == 4) {
                path = path.substring(0, path.length() - 1);    //去掉最后一个.
                res.add(path);  //搜到一个合法方案
            }
            return ;
        }

        if (k == 4) return; //已经搜满四个数，剪枝
        
        for (int i = u, t = 0; i < s.length(); i ++) {
            if (i > u && s.charAt(u) == '0') break;  //有前导'0'，不合法
            t = t * 10 + s.charAt(i) - '0';
            if (t <= 255) dfs(s, i + 1, k + 1, path + t + '.');  //合法，向下搜
            else break;     //不合法，退出
        }
    }
}
