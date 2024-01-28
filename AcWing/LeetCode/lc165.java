package AcWing.LeetCode;    //165. 比较版本号

class Solution {    //模拟题 + 字符串 + 双指针 + 时O(n)
    public int compareVersion(String v1, String v2) {
        int n1= v1.length(), n2 = v2.length();      //取出两字符串的长度
        for (int i = 0, j = 0; i < n1 || j < n2; ) {  //i，j双指针
            int a = i, b = j;   //a，b双指针
            while (a < n1 && v1.charAt(a) != '.') a ++;      //取出v1中的修订号字符串
            while (b < n2 && v2.charAt(b) != '.') b ++;      //取出v2中的修订号字符串
            //注意判断条件判断为判断a和b是否改变
            int x = a == i ? 0 : Integer.parseInt(v1.substring(i, a)); //将[i, a - 1]转为数字
            int y = b == j ? 0 : Integer.parseInt(v2.substring(j, b));  //将[j, b - 1]转为数字
            if (x > y) return 1;
            if (x < y) return -1;
            i = a + 1; j = b + 1;   //a，b所在位置为. , +1跳过.
        }

        return 0;
    }
}
