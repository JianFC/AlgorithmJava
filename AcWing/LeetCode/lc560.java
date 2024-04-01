package AcWing.LeetCode;        //560. 和为 K 的子数组

class Solution {    //哈希表 + 模板题 + 思维题 + 时O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];   //前缀和数组
        for (int i = 1; i <= n; i ++) s[i] = s[i - 1] + nums[i - 1];    //初始化前缀和数组
        
        Map<Integer, Integer> hash = new HashMap<>();   //存储每一个区间终点i之前各前缀和值 出现的次数
        hash.put(0, 1);     //初始时将s[0] = 0加入哈希表
        
        int res = 0;    //记录最终答案
        for (int i = 1; i <= n; i ++) {     //从前往后枚举每个区间终点 i - 1;
            res += hash.getOrDefault(s[i] - k, 0);      //第i个数之前s[i] - k出现的次数，即为合法区间的数量
            hash.put(s[i], hash.getOrDefault(s[i], 0) + 1);     //更新哈希表
        }

        return res;     //返回答案
    }
}
