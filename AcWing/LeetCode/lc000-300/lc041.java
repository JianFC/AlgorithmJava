package AcWing.LeetCode;        //41. 缺失的第一个正数

class Solution {    //解法1：哈希表
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hash = new HashSet<>();

        for (int i: nums) hash.add(i);  //将每个数加入hash表

        int res = 1;
        while (hash.contains(res)) res ++;   //哈希表中存在此元素则res ++

        return res;
    }
}