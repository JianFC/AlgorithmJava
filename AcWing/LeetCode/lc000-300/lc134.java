package AcWing.LeetCode;        //134. 加油站

class Solution {    //思维题 + 枚举 + 找性质（O(n^2) -> O(n)）
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0, j; i < n; ) {       //枚举每个起点
            int left = 0;                   //到达第i + j个点站时剩下的油量
            for (j = 0; j < n; j ++) {      //枚举每个点能向后走的站数的数量
                int k = (i + j) % n;        //下一个站点的下标
                left += gas[k] - cost[k];
                if (left < 0) break;        //该点不能行驶一周
            }
            if (j == n) return i;           //找到一个合法点
            i = i + j + 1;                  //i点不能走完一周，跳到i + j + 1的位置
        }

        return -1;
    }
}
