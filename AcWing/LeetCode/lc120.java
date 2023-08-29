package AcWing.LeetCode;

class Solution {    //递推，从下往上，简化边界判断
    public int minimumTotal(List<List<Integer>> f) {    
        for (int i = f.size() - 2; i >= 0; i--)     //从下往上看
            for (int j = 0; j <= i; j++)   //f[i][j] = min(f[i+1][j+1], f[i+1][j])
                f.get(i).set(j, Math.min(f.get(i + 1).get(j + 1), f.get(i + 1).get(j)) + f.get(i).get(j));
        
        return f.get(0).get(0); //f[0][0]为答案
    }
}
