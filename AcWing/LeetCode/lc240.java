package AcWing.LeetCode;    //240. 搜索二维矩阵 II

class Solution {    //思维题 + 时O(n + m)
    public boolean searchMatrix(int[][] ma, int target) {
        if (ma.length == 0 || ma[0].length == 0) return false;    //该矩阵为空
        int n = ma.length, m = ma[0].length;    //求出矩阵大小

        int i = 0, j = m - 1;   //定位到右上角
        while (i < n && j >= 0) {   //最坏循环O(n + m)次
            int t = ma[i][j];
            if (t == target) return true;    //找到答案
            else if (t > target) j --;  //删除一列
            else i ++;  //删除一行
        }

        return false;   //没有找到。
    }
}
