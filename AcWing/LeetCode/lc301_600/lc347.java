package AcWing.LeetCode;        //347. 前 K 个高频元素

class Solution {    //哈希表 + 计数排序思想 + 时O(n)
    public int[] topKFrequent(int[] nums, int k) {
        int N = nums.length, n = nums.length;
        
        Map<Integer, Integer> cnt = new HashMap<>();    //统计每个元素出现的次数
        for (int i = 0; i < n; i ++) cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);  //维护cnt
        
        int[] q = new int[N + 10];      //计数排序数组
        for (int v : cnt.values()) q[v] ++;     //更新q
        int i = n, t = 0;   //t表示目前从后往前扫描，出现次数的加和
        while (t < k) t += q[i --];     //最后i即为出现次数分界线（不包含i）
        
        int[] res = new int[k];     //存储答案
        int j = 0;
        for (int key : cnt.keySet())    //最后扫描map
            if (cnt.get(key) > i) res[j ++] = key;

        return res; 
    }
}
