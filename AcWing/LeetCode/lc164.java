package AcWing.LeetCode;    //164. 最大间距

class Solution {    //思维题 + 分区思想 + 时空O(n)
    public int maximumGap(int[] nums) {
        int n  = nums.length;
        int Min = (int)2e9, Max = (int)-1e9;    //存储全局最小最大值
        for (int i = 0; i < n; i ++) {      //找到全局最小最大值
            Min = Math.min(Min, nums[i]);
            Max = Math.max(Max, nums[i]);
        }
        if (n < 2 || Min == Max) return 0;      //特判
        
        Range[] r = new Range[n - 1];   //将Min去掉（左开右闭），最多划分为n - 1个区间
        for (int i = 0; i < n - 1; i ++) r[i] = new Range();    //记得初始化        

        int len = (Max - Min + n - 2) / (n - 1);    //每个区间长度，数学推导
        for (int x : nums) {    //将每个数放到对应的区间，并维护区间最大最小值
            if (x == Min) continue;     //Min不属于任何区间
            int k = (x - Min - 1) / len;    //该数应该存的区间索引
            r[k].min = Math.min(x, r[k].min);   //维护区间最小值
            r[k].max = Math.max(x, r[k].max);    
            r[k].used = true;   //该区间中有数
        }
        
        int res = 0;    //存储最终答案
        for (int i = 0, last = Min; i < n - 1; i ++) //从前往后扫描每个区间, last存储上个区间最大值
            if (r[i].used) {    //该区间中有数
                res = Math.max(res, r[i].min - last);   //更新答案
                last = r[i].max;    //更新双指针last
            }
        
        return res;
    }

    class Range {
        int min, max;    //该区间最大值和最小值，区间左开右闭
        boolean used;   //标记此区间是否存有数
        Range() {
            min = (int)2e9; max = (int)-1e9; used = false;  //初始化
        }
    }
}
