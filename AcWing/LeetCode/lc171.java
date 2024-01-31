package AcWing.LeetCode;        //171. Excel 表列序号

class Solution {      //进制转换 + 模板题 + 秦九韶算法
    public int titleToNumber(String str) {
        int a = 0;  //第一部分
        for (long i = 0, p = 26; i < str.length() -  1; i ++, p *= 26) a += p;  //long防止p爆int
        
        int b = 0;  //第二部分，秦九韶算法，b + 1为length位字母表示的数的序号
        for (int i = 0; i < str.length(); i ++) b = b * 26 + str.charAt(i) - 'A';
        
        return a + b + 1;   //最终答案 + 1，让下标从1开始
    }
}
