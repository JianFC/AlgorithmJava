package AcWing.LeetCode;        //54. 螺旋矩阵

class Solution {    //方向向量 + 模拟题 + 枚举步数
    public List<Integer> spiralOrder(int[][] mx) {
        List<Integer> res = new ArrayList<>();
        int n = mx.length;
        if (n == 0) return res;
        int m =  mx[0].length;
        boolean[][] st = new boolean[n][m];     //判重数组，判断当前位置有没有走过

        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};   //移动向量，走的顺序为0123，0123...
        //枚举n * m步，x，y代表坐标，d代表当前方向向量
        for (int i = 0, x = 0, y = 0, d = 0; i < n * m; i ++) {      
            res.add(mx[x][y]);
            st[x][y] = true;    //更新判重数组，该数已经走过
            
            int a = x + dx[d], b = y + dy[d];   //下一个位置
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]) {   //需要更新方向
                d = (d + 1) % 4;  //更新方向向量，0123，0123...
                a = x + dx[d]; b = y + dy[d];
            }

            x = a; y = b;   //更新下一步坐标
        }

        return res;
    }
}