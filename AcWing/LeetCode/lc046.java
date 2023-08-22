package AcWing.LeetCode;

class Solution {    //DFS
    int N = 10;
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] st = new boolean[N];  //存储每个数是否用过

    public List<List<Integer>> permute(int[] nums) {
            dfs(nums, 0);

            return res;
    }

    void dfs(int[] nums, int u) {
        if (u == nums.length) {     //搜到一种组合
            res.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st[i]) {   //当前数没用
                path.add(nums[i]);  //将当前数加入path
                st[i] = true;
                dfs(nums, u + 1);
                path.remove(path.size() - 1);      //恢复现场
                st[i] = false;
            }
        }
    }
}
