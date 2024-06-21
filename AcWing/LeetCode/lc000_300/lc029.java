package AcWing.LeetCode;        //29. 两数相除

class Solution {    //倍增 + 快速幂
    public int divide(int x, int y) {
        boolean sig = true; long res = 0;
        if (x > 0 && y < 0 || x < 0 && y > 0) sig = false;

        long a = Math.abs((long)x), b = Math.abs((long)y);  //绝对值前转为long，防止溢出
        List<Long> exp = new ArrayList<Long>();     //此处不方便使用数组
        for (long i = b; i <= a; i = i + i) exp.add(i);   //预处理b * 2^0, b * 2^1, b * 2^2, b * 2^3...

        //倍增的思想
        for (int i = exp.size() - 1; i >= 0; i --) {
            if (a >= exp.get(i)) {
                a -= exp.get(i);
                res += (long)1 << i;  //转为long，防止溢出
            }
        }
        
        res = sig ? res: -res;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int)res;    //以int返回
        
    }
}