package AcWing.LeetCode;        //168. Excel表列名称

class Solution {    //进制模拟 + 思维题 + 时O(logn)
    public String convertToTitle(int n) {
        int k = 1;      //求出n需要用多少位表示
        for (long p = 26; n > p; p *= 26) {
            n -= p;     //最终将n更新为字母k位表示中的第多少个数
            k ++;       //更新位数
        }

        n -- ;  //将下标映射为从0开始，表示k位表示中的第n + 1个数
        String res = "";        //存储最终答案
        while (k -- > 0) {
            res += (char)(n % 26 + 'A');    //低位在前，高位在后存储，注意转换为char
            n /= 26;    //更新n
        }

        res = reverse(res);     //翻转字符串

        return res;     //返回答案
    }

    String reverse(String str) {    //翻转字符串
        char[] cs = str.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; i ++, j --) {
            char c = cs[i]; cs[i] = cs[j]; cs[j] = c;
        }
        return new String(cs);
    }
}
