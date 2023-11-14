package AcWing.LeetCode;        //67. 二进制求和

class Solution {    //模拟 + 高精度加法思想
    public String addBinary(String a, String b) {
        a = reverse(a, 0, a.length() - 1);
        b = reverse(b, 0, b.length() - 1);
        String res = "";    //定义答案
        //t表示进位
        for (int i = 0, t = 0; i < a.length() || i < b.length() || t > 0; i ++) {
            if (i < a.length()) t += a.charAt(i) - '0';     //记得转为数字
            if (i < b.length()) t += b.charAt(i) - '0';
            res += t % 2;
            t /= 2;
        }
        res = reverse(res, 0, res.length() - 1);

        return res;
    }

    String reverse(String s, int l, int r) {
        char[] ss = s.toCharArray();
        while (l < r) {
            char c = ss[l]; ss[l] = ss[r]; ss[r] = c;
            l ++; r --;
        }
        return String.valueOf(ss);
    }
}
