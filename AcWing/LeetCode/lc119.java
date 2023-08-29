package AcWing.LeetCode;

class Solution {    //递推+滚动数组
    public List<Integer> getRow(int n) {
        int[][] f = new int[2][n + 1];
        for (int i = 0; i <= n; i++) {
            f[i & 1][0] = f[i & 1][i] = 1;  // i % 2等价于i & 1
            for (int j = 1; j < i; j++) 
                f[i & 1][j] = f[i - 1 & 1][j - 1] + f[i - 1 & 1][j];
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) res.add(f[n & 1][i]);
        return res;
    }
}
