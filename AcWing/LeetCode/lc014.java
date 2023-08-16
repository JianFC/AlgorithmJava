package AcWing.LeetCode;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) return res;

        for (int i=0; ; i++) {
            if (i >= strs[0].length()) return res;
            char c = strs[0].charAt(i);
            for (String s: strs) {  //遍历每一个字符串
                if (i >= s.length() || s.charAt(i) != c) return res;
            }
            res += c;
        }
    }
}