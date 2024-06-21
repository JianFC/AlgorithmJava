package AcWing.LeetCode;        //214. 最短回文串

class Solution {    //回文串 + kmp next思想 + 思维题 + 时O(n) 
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();   //翻转s
        int n = s.length(); String ss = s;  //原串进行备份
        s = ' ' + s + '#' + t;      //保证s下标从1开始，方便kmp，末尾补上'#'假设其不存在，保证ne不越界，将s作对称
        n = n * 2 + 2;  //更新字符串长度
        
        int[] ne = new int[n];  //kmp的next数组
        for (int i = 2, j = 0; i < n; i ++) {   //kmp求next数组过程
            while (j > 0 && s.charAt(i) != s.charAt(j + 1)) j = ne[j]; 
            if (s.charAt(i) == s.charAt(j + 1)) j ++;   //可以匹配，j后移
            ne[i] = j;      //更新next数组
        }

        int len = ne[n - 1];    //原串中最长的回文前缀长度
        String left = ss.substring(0, len), right = ss.substring(len);
        return new StringBuilder(right).reverse().toString() + ss;     //拼成最终的回文串
    }
}
