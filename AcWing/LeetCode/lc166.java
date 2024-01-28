package AcWing.LeetCode;    //166. 分数到小数

class Solution {    //模拟题 + 高精度除法 + 模板题 + 思维题 + 时O(n)，余数只能为[1, n - 1]，一定在O(n)内
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator;    //使用long，防止爆int
        if (x % y == 0) return x / y + "";  //可以整除
        String res = "";    //存储最终答案
        if ((x < 0) ^ (y < 0)) res += "-";      //x和y有一个小于0，结果为负
        x = Math.abs(x); y = Math.abs(y);
        res += x / y;   //整数部分
        
        x %= y;     //余数
        res += ".";     //加上小数点
        Map<Long, Integer> hash = new HashMap<>();  //余数-商在res中的位置的哈希表
        while (x != 0) {    //余数不为0，处理小数部分
            hash.put(x, res.length());    //将余数及其对应的商所存的位置放入哈希表
            x *= 10;    //余数扩大十倍
            res += x / y;   //余数的商
            x %= y;    //下一次的余数
            if (hash.containsKey(x)) {  //余数已经在哈希表存在，找到了循环节，处理循环部分
                res = res.substring(0, hash.get(x)) + "(" + res.substring(hash.get(x)) + ")";
                break;  //退出循环
            }
        }

        return res;
    }
}
