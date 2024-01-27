package AcWing.LeetCode;        //125. 验证回文串

class Solution {    //双指针
    boolean check(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i ++, j --) {
            while (i < j && !check(s.charAt(i))) i ++;   //非法字符，跳过
            while (i < j && !check(s.charAt(j))) j --;   //非法字符，跳过
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;   //不相等
        }

        return true;
    }
}
