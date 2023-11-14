package AcWing.LeetCode;        //60. 排列序列

class Solution {    //类计数DP思路 + 模拟 + 代码实现
    public String getPermutation(int n, int k) {
        String res = "";
        boolean[] st = new boolean[n + 1];  //判重数组，记录每个数的使用情况
        for (int i = 0; i < n; i ++) {   //枚举每次确定的数的位置
            int fact = 1;   //预处理当前前缀的序列个数
            for (int j = 1; j <= n - i - 1; j ++) fact *= j; 

            for (int j = 1; j <= n; j ++) {  //枚举当前位置应该为哪个数
                if (!st[j]) {   //当前数没有被用过
                    if (fact < k) k -= fact;    //更新k
                    else {      //fact >= k, 第k个排列在当前序列中
                        res = res + j;   //将当前数加入答案中
                        st[j] = true;
                        break;  //注意break，只确定一个数
                    }
                }
            }
        }

        return res;
    }
}