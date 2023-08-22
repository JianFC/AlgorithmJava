package AcWing.LeetCode;

class Solution {    //模拟+分块
    public int[][] insert(int[][] a, int[] b) {
        List<int[]> res = new ArrayList<>();
        int n = a.length;
        
        int k = 0;  //扫描指针
        while (k < n && a[k][1] < b[0]) res.add(a[k++]);    //处理左边没有交集的部分

        if (k < n) {    //处理中间有交集的部分
            b[0] = Math.min(b[0], a[k][0]);   //更新新区间左端点
            //更新新区间右端点
            while (k < n && a[k][0] <= b[1]) b[1] = Math.max(b[1], a[k++][1]);
        }
        res.add(b); //将更新后的区间加入res

        while (k < n) res.add(a[k++]);  //将右边剩余部分加入答案

        int[][] ans = new int[res.size()][];    //数据格式转换
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);

        return ans;
    }
}
