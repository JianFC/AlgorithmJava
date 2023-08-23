package AcWing.LeetCode;

class Solution {    //坐标转换+二分
    public boolean searchMatrix(int[][] ma, int tg) {
        if (ma.length == 0) return false;
        int n = ma.length, m = ma[0].length;
        int l =  0, r = n * m - 1;  //将ma展平成一维数组
        while (l < r) {
            int mid = l + r >> 1;
            if (ma[mid / m][mid % m] >= tg) r = mid; //x = mid/m, y = mid%m;
            else l = mid + 1; 
        }

        return ma[r / m][r % m] == tg;
    }
}
