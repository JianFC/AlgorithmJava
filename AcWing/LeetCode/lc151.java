package AcWing.LeetCode;        //151. 反转字符串中的单词

class Solution {    //双指针 + 思维题 + 时间复杂度O(n)
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int k =  0;     //记录去除多余空格后的字符串长度
        for (int i = 0; i < cs.length; i ++) {
            if (cs[i] == ' ') continue; //跳过连续空格
            int j = i, t = k;   //j双指针，从字符串中取出单词，存到cs的前部分
            while (j < cs.length && cs[j] != ' ') cs[t ++] = cs[j ++];   
            reverse(cs, k, t - 1);      //1. 将取出的单词翻转
            if (t < cs.length) cs[t ++] = ' ';    // 取出的单词后补上空格
            i = j; k = t;   //更新指针和后续写入位置
        }
        if (cs[k - 1] == ' ') k --;     //去掉末尾空格
        reverse(cs, 0, k - 1);      //2. 进行字符串的整体翻转
        return new String(cs, 0, k);
    }

    void reverse(char[] cs, int l, int r) {     //将cs中[l, r]进行翻转
        while (l < r) {
            char c = cs[l]; cs[l] = cs[r];  cs[r] = c;  
            l ++ ; r --;    //更新双指针
        }
    }
}
