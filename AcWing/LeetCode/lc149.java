package AcWing.LeetCode;        // 149. 直线上最多的点数

class Solution {        // 暴力 + 思维题 + 时间复杂度O(logn * n^2)
    static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;   //求a和b的最大公约数
    }

    public int maxPoints(int[][] p) {
        int res = 0;    //存储最终答案
        int n = p.length;  //点的个数
        for (int i = 0; i < n; i ++) {      //枚举中心点
            int vl = 0, cp = 0;     //vl表示和中心点垂直的线上的点的数量，cp表示和中心点重合的点的数量
            Map<String, Integer> hash = new HashMap<>();    //存储直线-点数的哈希表
            for (int j = 0; j < n; j ++)    //枚举经过中心点的所有直线
                if (p[i][0] == p[j][0] && p[i][1] == p[j][1]) cp ++;    //和中心点重合
                else if (p[i][0] == p[j][0]) vl ++;     //在垂线上
                else {
                    int y = p[i][1] - p[j][1];  //delta y
                    int x = p[i][0] - p[j][0];  //delta x
                    int c = gcd(x, y);  //x, y的最大公约数，用于得到斜率的唯一表示
                    y /= c; x /= c; 
                    String k = y + "/" + x; //得到唯一斜率字符串表示
                    hash.put(k, hash.getOrDefault(k, 0) + 1);   //更新哈希表
                }

                int ps = vl;    //存储以i为中心点的所有直线的点的最大值
                for (int v: hash.values()) ps = Math.max(ps, v);  //求出i中心点的所有直线的点数最大值
                res = Math.max(res, ps + cp);       //加上和中心点重合的点的数量
        }

        return res;
    }
}