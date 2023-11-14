package AcWing.LeetCode;        //1. 两数之和

import java.util.*;

public class lc001 {  // 1. 两数之和 朴素版
    public int[] twoSum(int[] nums, int target) {
        int[] res = null;
        for (int i = 0; i< nums.length; i ++) 
            for (int j = 0; j < i; j ++)
                if (nums[i] + nums[j] == target) {
                    res = new int[] {i, j}; break;
                }
        return res;
    }

    public int[] twoSum_2(int[] nums, int target) {     //hash做法，O(n)
        Map<Integer, Integer> hash = new HashMap<>();
        int[] res = null;
        for (int i = 0; i < nums.length; i ++) {
            int another = target - nums[i];
            if (hash.containsKey(another)) {
                res = new int[]{hash.get(another), i};
                break;
            }
            hash.put(nums[i], i);   //值-索引 kv对
        }
        return res;
    }
}
