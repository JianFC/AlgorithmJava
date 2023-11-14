package AcWing.LeetCode;        //12. 整数转罗马数字

class Solution {    //模拟 + 思维题
    public String intToRoman(int num) {
        //时间复杂度O(logN), ref link: https://www.acwing.com/solution/content/101/
        int[] values = {
            1000, 
            900, 500, 400, 100, 
            90, 50, 40, 10, 
            9, 5, 4, 1
        };  //13种组合
        String[] reps = {
            "M", 
            "CM", "D", "CD", "C", 
            "XC", "L", "XL", "X", 
            "IX", "V", "IV", "I"
        };

        //贪心
        String res = "";
        for (int i = 0; i < 13; i ++)
            while (num >= values[i]) {
                num -= values[i];
                res += reps[i];
            }
        
        return res;
    } 
} 