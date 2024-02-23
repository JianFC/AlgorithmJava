package AcWing.LeetCode;        //73. 矩阵置零

class Solution {    //模拟 + 思维题 + 时间复杂度：常数遍O(n ^ 2)，即O(n ^ 2)
    public void setZeroes(int[][] ma) {
        if (ma.length == 0) return;
        int n = ma.length, m = ma[0].length;
        
        int r0 = 1, c0 = 1; //r0记录第0行有没有0，c0记录第0列有没有0
        //计算r0和c0
        for (int i = 0; i < m; i ++) if (ma[0][i] == 0) r0 = 0;
        for (int i = 0; i < n; i ++) if (ma[i][0] == 0) c0 = 0;

        //使用ma[0, i]来记录第i列有没有0
        for (int i = 1; i < m; i ++) //枚举每一列
            for (int j = 0; j < n; j ++) //计算该列是否包含0
                if (ma[j][i] == 0) ma[0][i] = 0;
        
        //使用ma[i, 0]来记录第i行有没有0
        for (int i = 1; i < n; i ++) //枚举每一行
            for (int j = 0; j < m; j ++) //计算改行是否包含0
                if (ma[i][j] == 0) ma[i][0] = 0;
        
        //更新1 - m列
        for (int i = 1; i < m; i ++)
            if (ma[0][i] == 0)
                for (int j = 0; j < n; j ++) ma[j][i] = 0;
        
        //更新1 - n行
        for (int i = 1; i < n; i ++)
            if (ma[i][0] == 0)
                for (int j = 0; j < m; j ++) ma[i][j] = 0;
        
        //更新第0行
        if (r0 == 0) for (int i = 0; i < m; i ++) ma[0][i] = 0;
        //更新第0列
        if (c0 == 0) for (int i = 0; i < n; i ++) ma[i][0] = 0;
    }
}