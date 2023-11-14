package AcWing.LeetCode;        //5. 最长回文子串

class Solution {
    public String longestPalindrome(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i ++) {
            //回文子串长度为奇数
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { 
                l --; r ++;
            }
            if (r - l - 1 > str.length()) str = s.substring(l + 1, r);    //substring [a, b)

            //回文子串长度为偶数
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --; r ++;
            }
            if (r - l - 1 > str.length()) str = s.substring(l + 1, r);
        }

        return str;
    }
}