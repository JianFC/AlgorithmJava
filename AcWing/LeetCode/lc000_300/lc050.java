package AcWing.LeetCode;        //50. Pow(x, n)

class Solution {    //快速幂考察
    public double myPow(double x, int n) {
        boolean sig = n < 0;
        long k = Math.abs((long)n);
        
        double res = 1;
        while (k != 0) {
            if ((k & 1) == 1) res *= x;
            k >>= 1;
            x *= x;
        }

        if (sig) res = 1 / res;
        return res;
    }
}
