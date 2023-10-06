package AcWing.LeetCode;

class Solution {    //DFS
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  //”abc“与下标2对应

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return res;  //返回空串
        dfs(digits, 0, "");     //深搜
        return res;
    }

    void dfs(String digits, int u, String path) {
        if (u == digits.length()) res.add(path);
        else {
            int ind = digits.charAt(u) - '0';     //下标
            for (int i = 0; i < map[ind].length(); i ++) {
                dfs(digits, u+1, path + map[ind].charAt(i));
            }
        }
    }
}