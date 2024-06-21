package AcWing.LeetCode;        //118. 杨辉三角

class Solution {    //递推 + 模拟
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i ++) {              //生成n行
            List<Integer> line = new ArrayList<>(); //存储每一行
            line.add(1);                            //第一个数是1
            for (int j = 1; j < i; j ++)            //递推，f[i][j] = f[i - 1][j - 1] + f[i - 1][j]
                line.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            if (i > 0) line.add(1);                 //最后一个数是1
            res.add(line);
        }

        return res;
    }
}
