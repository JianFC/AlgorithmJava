package AcWing.LeetCode;        //167. 两数之和 II - 输入有序数组

class Solution {    //双指针 + 单调性优化 + 时O(n)
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; i ++) {  //注意不能重复使用元素，i < j
            while (i < j && numbers[i] + numbers[j] > target) j --; //找到最大的j，使得ai + aj <= target
            if (i < j && numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};     //找到答案
        }
        return null;
    }
}