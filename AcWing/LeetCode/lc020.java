package AcWing.LeetCode;        //20. 有效的括号

class Solution {    //DS，stack
    static int N = 100000;

    public boolean isValid(String s) {
        char[] stk = new char[N]; int tt = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') stk[++ tt] = c;
            else {
                if (tt > 0 && Math.abs(c - stk[tt]) <= 2) tt--;     //括号ASCII性质
                else return false;
            }
        }

        return (tt == 0? true: false);
    }
}
