package AcWing.LeetCode;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;   //去重
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  //去重
                for (int k = j + 1, u = nums.length - 1; k < u; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (k < u - 1 && (long)nums[i] + nums[j] + nums[k] + nums[u-1] >= target) u--;   //转long防溢出
                    if ((long)nums[i] + nums[j] + nums[k] + nums[u] == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[u]));
                }
            }
        }

        return res;
    }
}