package AcWing.LeetCode;        //204. 计数质数

class Solution {    //线性筛模板 + 时O(n)
    public int countPrimes(int n) {
        boolean[] st = new boolean[n + 1];      //线性筛合法性数组
        int[] primes = new int[n + 1]; int cnt = 0;     //存储2 ~ n中所有质数和质数的数量
        for (int i = 2; i < n; i ++) {
            if (!st[i]) primes[cnt ++] = i;     //该数是是质数

            for (int j = 0; primes[j] <= n / i; j ++) {     //线性筛
                st[primes[j] * i] = true;   //筛掉i * primes[j]，每个合数只会被其最小质因子筛掉
                if (i % primes[j] == 0) break;
            }
        }
        
        return cnt;
    }
}
