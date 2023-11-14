package AcWing.LeetCode;        //28. 找出字符串中第一个匹配项的下标

class Solution {    //KMP
    static int N = 10010;

    static int n, m;
    static char[] s = new char[N], p = new char[N];
    static int[] ne = new int[N];

    public int strStr(String haystack, String needle) {
        haystack = " " + haystack; needle = " " + needle;
        s = haystack.toCharArray(); p = needle.toCharArray();
        n = s.length - 1; m = p.length - 1;     //n和m分别表示目标串和模板串的长度
        
        //求ne数组:ne[1] = 0;
        for (int i = 2, j = 0; i < p.length; i ++) {
            while (j != 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j ++;
            ne[i] = j;      //更新ne[i];
        }

        //匹配模板串
        for (int i = 1, j = 0; i < s.length; i ++) {  //i是要匹配的位置，j是已经匹配的位置
            while (j != 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j ++;
            if (j == m) return i - j;
        }

        return -1;
    }
}
