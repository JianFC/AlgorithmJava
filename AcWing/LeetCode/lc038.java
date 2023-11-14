package AcWing.LeetCode;        //38. 外观数列

class Solution {    //双指针
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i ++) {
            String t = "";  //存储答案
            for (int j = 0; j < s.length(); ) {
                int k = j + 1;    //从k的下一位置开始看
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k ++;   //第一个不等的位置
                t += String.valueOf(k - j) + s.charAt(j);     // k - j数量
                j = k;  //更新j
            }
            s = t;      //更新s
        }

        return s;
    }
}
