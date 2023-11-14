package AcWing.LeetCode;        //58. 最后一个单词的长度

class Solution {    //双指针
    public int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i --) {     //从后往前，更快
            if (s.charAt(i) == ' ') continue;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j --;
            return i - j;
        }

        return 0;
    }
}
