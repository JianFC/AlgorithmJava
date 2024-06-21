package AcWing.LeetCode;        //238. 除自身以外数组的乘积

class Solution {    //前后缀分解(同股票问题模型) + 时O(n) + 空O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];   //前缀乘积数组，也作为答案存储数组
        
        p[0] = 1;   //初始化前缀乘积数组, p[i] = a1 * a2 * ... * a(i - 1)
        for (int i = 1; i < nums.length; i ++) p[i] = p[i - 1] * nums[i - 1];   

        for (int i = nums.length - 1, s = 1; i >= 0; i --) {    //从后往前递推，维护后缀s
            p[i] *= s;      //p[i]最终存储p[i] * s[i]
            s *= nums[i];   //维护后缀乘积
        }

        return p;
    }
}