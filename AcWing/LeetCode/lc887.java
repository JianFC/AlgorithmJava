package AcWing.LeetCode;    //887. 鸡蛋掉落

class Solution {    //特殊DP + 思维题记忆 + 参考ac1048
    public int superEggDrop(int k, int n) {
        int[][] f = new int[n + 10][k + 10];

        int res = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= k; j ++)
                f[i][j] = f[i - 1][j -  1] + f[i - 1][j] + 1;
            
            if (f[i][k] >= n) {
                res = i;
                break;
            }
        }

        return res;
    }
}
