package AcWing.LeetCode;

class Solution {    //模拟+大数乘法
    public String multiply(String num1, String num2) {
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
        int n = num1.length(), m = num2.length();
        
        //逆序存储
        for (int i = n - 1; i >= 0; i--) A.add(num1.charAt(i) - '0');
        for (int i = m - 1; i >= 0; i--) B.add(num2.charAt(i) - '0');

        int[] C = new int[n + m];    //存储结果，有n+m位，逆序存储
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i + j] += A.get(i) * B.get(j);     //技巧，先不进位，后面进位，注意+=
        
        
        //处理进位
        for (int i = 0, t = 0; i < n + m; i++) {
            t += C[i];      //t表示进位
            C[i] = t % 10;
            t /= 10;
        }

        //处理前导0
        int k = n + m - 1;
        while (k >= 0 && C[k] == 0) k--;

        if (k < 0) return "0";  //特判

        String res = "";
        while (k >= 0) res += C[k--];   //处理结果

        return res;
    }
}
