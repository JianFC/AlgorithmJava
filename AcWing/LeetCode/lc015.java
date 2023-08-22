package AcWing.LeetCode;

class Solution {    //双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();    //定义答案
        Arrays.sort(nums, 0, nums.length);  //双指针使用时需保证单调有序性
        for (int i = 0; i < nums.length; i++) {     //设nums[i]最小
            if (i != 0 && nums[i] == nums[i - 1]) continue;   //i不为0时去重
            //j, k分别为指向i下一个位置和数组末尾的双指针
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {    
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  //j>i+1时去重
                //试探法，如果k的下一个位置数k - 1满足条件，注意符号为 >=, 则将k移到下个位置
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= 0) k--;
                if (nums[i] + nums[j] + nums[k] == 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }

        return res;
    }
}
