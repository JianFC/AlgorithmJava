package AcWing.LeetCode;        //47. 全排列 II

class Solution {    //DFS + 去重处理技巧
    int N = 10;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>(); 
    boolean[] st = new boolean[N];

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums, 0, nums.length);  //使用前排序
        dfs(nums, 0);

        return res;
    }

    void dfs(int[] nums, int u) {
        if (u == nums.length) {
            res.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!st[i]) {
                //在相同的数中规定一个顺序，必须按顺序用，从而保证相同的数的排列只有一个
                //如果上一个数没有使用，则此处不能使用该数，跳过
                if (i > 0 && nums[i - 1] == nums[i] && !st[i - 1]) continue;
                path.add(nums[i]);
                st[i] = true;
                dfs(nums, u + 1);
                path.remove(path.size() - 1);   //恢复现场
                st[i] = false;
            }
        }

        
    }
}
