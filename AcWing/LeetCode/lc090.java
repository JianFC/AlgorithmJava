package AcWing.LeetCode;        //90. 子集 II（类似lc039）

class Solution {    //DFS + 枚举方案 + 模板题
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums, 0, nums.length);  //让相同元素相邻
        dfs(nums, 0);

        return res;
    }

    void dfs(int[] nums, int u) {
        if (u == nums.length) {     //找到一种方案
            res.add(new ArrayList(path));
            return ;
        }

        int k = u + 1;
        while (k < nums.length && nums[k] == nums[u]) k ++;  //k记录重复元素的右边界(不含)

        for (int i = 0; i <= k - u; i ++) {   //枚举nums[u]选多少个
            dfs(nums, k);
            path.add(nums[u]);  //放到dfs之后，实现i = 0，选0个，i = 1，选1个..i = j，选j个
        }

        for (int i = 0; i <= k - u; i ++) path.remove(path.size() - 1);   //恢复现场
    }
} 
