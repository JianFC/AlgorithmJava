package AcWing.LeetCode;        //394. 字符串解码

class Solution {    //dfs + 时O(指数级别)
    int u;      //u表示当前处理到s的哪个位置了，初始为0

    public String decodeString(String s) {
        u = 0;
        return dfs(s);
    }

    String dfs(String s) {
        String res = "";
        
        while (u < s.length() && s.charAt(u) != ']') {    //处理每一个]之前的区间
            char c = s.charAt(u);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {     //注意||
                res += c; u ++;     //是字符直接添加到res中
            }
            else if (c >= '0' && c <= '9') {    //是数字
                int k = u, x = 0;   //x存储数字是多少
                while (k < s.length() && Character.isDigit(s.charAt(k))) 
                    x = x * 10 + s.charAt(k ++) - '0';
            
                u = k + 1;      //跳过一个'['
                String y = dfs(s);
                u ++;   //跳过一个]，进入下一个]的区间
                while (x -- > 0) res += y;      //更新res
            }
        }

        return res;     //返回答案
    }
}
