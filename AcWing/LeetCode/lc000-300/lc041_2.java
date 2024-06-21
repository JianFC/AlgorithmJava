package AcWing.LeetCode;        //41. 缺失的第一个正数

class Solution {    //解法2：索引映射，类似于基数排序，使得i位置上的数为nums[i]
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i ++) {   //将x∈[1, N]置换到数组中x - 1下标处的位置
            //由于每次的交换操作都会使得某一个数交换到正确的位置，因此交换的次数最多为N，整个方法的时间复杂度为 O(N)
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {     //最后一个条件防止死循环
                //swap(nums[i] 和 nums[nums[i]])
                int t = nums[nums[i] - 1];  
                nums[nums[i] - 1] = nums[i];      //注意更新的顺序，nums[i]不能先更新
                nums[i] = t;
            } 
        }

        for (int i = 0; i < n; i ++)
            if (nums[i] != i + 1) return i + 1;

        return n + 1;     //注意返回n + 1
    }
}
