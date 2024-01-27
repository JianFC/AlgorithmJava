package AcWing.LeetCode;        //96. 不同的二叉搜索树

class Solution {    //递推 + BST性质 + 模板题
    public int numTrees(int n) {
        int[] f = new int[n + 1];   //f[i]代表长度为i的序列能够形成的BST的个数
        f[0] = 1;   //初始化边界
        for (int i = 1; i <= n; i ++)    //枚举长度
            for (int j = 1; j <= i; j ++)   //枚举root的位置
                f[i] += f[j - 1] * f[i - j];    //递推式
        
        return f[n];
    }
}
