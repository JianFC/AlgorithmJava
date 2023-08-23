package AcWing.LeetCode;

class Solution {    //dfs
    List<String> res = new ArrayList<>();   

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return res;
    }

    void dfs(int n, int lc, int rc, String seq) {   //lc表示左括号数量，rc表示右括号数量
        if (lc == n && rc == n) res.add(seq);
        else {
            if (lc < n) dfs(n, lc + 1, rc, seq + "(");      //lc<n时可生成左括号
            if (rc < n && lc > rc) dfs(n, lc, rc + 1, seq + ")");   //右括号生成条件
        }
    }
}
