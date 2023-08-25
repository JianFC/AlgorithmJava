package AcWing.LeetCode;

class Solution {    //双指针
    public int threeSumClosest(int[] nums, int target) {
        PII res = new PII(0x3f3f3f3f, 0x3f3f3f3f);
        Arrays.sort(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                //试探法
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= target) k--;
                if (nums[i] + nums[j] + nums[k] == target) return target;   //特判

                //情况一
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < res.first) 
                    res = new PII(Math.abs(target - sum), sum);
                
                //情况二
                sum = nums[i] + nums[j] + nums[k - 1];
                if (j < k - 1 && Math.abs(target - sum) < res.first)
                    res = new PII(Math.abs(target - sum), sum);
            }
        }

        return res.second;
    }

    class PII {
        int first, second;
        PII(int f, int s) {
            first = f; second = s;
        }
    }
}
