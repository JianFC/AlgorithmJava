package AcWing.LeetCode.lc000_300;      //279. 完全平方数

class Solution {    //解法1：数学定理（四平方和，三平方和）+ 时O(sqrt(n) + o(logn))
    boolean check(int x) {  //检查x是否为完全平方数
        int r = (int)Math.sqrt(x);
        return r * r == x;
    }

    public int numSquares(int n) {
        if (check(n)) return 1;     //情况1

        for (int a = 1; a <= n / a; a ++)     //情况2，除法防止溢出，时O(sqrt(n))
            if (check(n - a * a)) return 2;

        while (n % 4 == 0) n /= 4;  //情况3，三平方和定理，n不等于4^a(8b + 7)
        if (n % 8 != 7) return 3; 
        
        return 4;   //情况4，四平方和定理
    }
}
