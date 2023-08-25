package AcWing.LeetCode;

class Solution {    //单调栈应用+思维题+枚举每一行矩形的下边界+预处理递推
    int lRA(int[] h) {  //84题模板
        int n = h.length;
        int[] left = new int[n], right = new int[n];
        int[] stk = new int[n + 1]; int tt = 0;

        for (int i = 0; i < n; i++) {
            while (tt > 0 && h[stk[tt]] >= h[i]) tt--;
            if (tt == 0) left[i] = -1;
            else left[i] = stk[tt];
            stk[++tt] = i;
        }

        tt = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (tt > 0 && h[stk[tt]] >= h[i]) tt--;
            if (tt == 0) right[i] = n;
            else right[i] = stk[tt];
            stk[++tt] = i;
        }

        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, h[i] * (right[i] - left[i] - 1));
        return res;
    }

    public int maximalRectangle(char[][] ma) {
        if (ma.length == 0 || ma[0].length == 0) return 0;  //短路性质
        int n = ma.length, m = ma[0].length;
        int[][] h = new int[n][m];  //h[i][j]代表点(i, j)上方有多少个连续的1

        //预处理h数组
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (ma[i][j] == '1') {
                    if (i > 0) h[i][j] = 1 + h[i - 1][j];   //递推
                    else h[i][j] = 1;
                }
        //扫描每一行，枚举每行矩形的下分界线
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, lRA(h[i]));

        return res;
    }
}
