package AcWing.LeetCode;

class Solution {    //思维题+栈+合法括号性质考察，解题思路见图解
    static int N = 100010;
    public int longestValidParentheses(String s) {
        int[] stk = new int[N]; int tt = 0;   //栈，存储每个(的下标
        
        int res = 0;    //存储结果
        for (int i = 0, st = -1; i < s.length(); i++) {     //st表示每一个分段起点的前一个位置
            if (s.charAt(i) == '(') stk[++tt] = i;  //下标入栈
            else {
                if (tt > 0) {   //当栈还有元素时
                    tt--;   //遇到)弹出栈顶元素  
                    if (tt > 0) res = Math.max(res, i - stk[tt]); //此时栈顶(的到当前）的长度即为当前）的最长合法字串长度
                    else res = Math.max(res, i - st);  //此时i到st的距离即为合法子串的长度
                }
                else st = i;    //此时)数量>(数量，需要开始新一个分段
            }
        }

        return res;
    }
}