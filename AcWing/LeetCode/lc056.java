package AcWing.LeetCode;

class Solution {   //贪心+模板题+数据格式转换
    public int[][] merge(int[][] a) {
        List<int[]> res = new ArrayList<>();    //存储结果
        if (a.length == 0) return new int[][]{{}};

        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);  //将所有区间按照左端点排序
        int l = a[0][0], r = a[0][1];   //[l. r]维护一个当前合并后的区间
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > r) {  //当前区间左端点 > 维护区间右端点
                res.add(new int[]{l, r});   //加入结果，新开区间
                l = a[i][0]; r = a[i][1];   //新开区间
            }
            else r = Math.max(r, a[i][1]); ////当前区间左端点 <= 维护区间右端点, 更新r
        }

        res.add(new int[]{l, r});   //将最后一个区间加入结果
        
        int[][] ans = new int[res.size()][2];   //转换格式
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);

        return ans;
    }
}
