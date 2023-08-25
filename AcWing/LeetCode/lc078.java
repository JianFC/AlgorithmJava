package AcWing.LeetCode;

class Solution {    //迭代+二进制优化
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n =  nums.length;
        for (int i = 0; i < 1 << n; i++) {  //二进制优化+迭代做法
            List<Integer> path = new ArrayList<>(); //存储路径
            for (int j = 0; j < n; j++)     //枚举每一位是否为1
                if ((i >> j & 1) == 1) path.add(nums[j]);
            res.add(path);
        }

        return res;
    }
}
