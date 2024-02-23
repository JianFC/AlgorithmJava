package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac338 {    //AcWing 338. 计数问题
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    //返回num从[l高位, r低位]构成的数字 
    static int get(List<Integer> num, int l, int r) {
        int res = 0;
        for (int i = l; i >= r; i --) res = res * 10 + num.get(i);
        return res;
    }
    
    //返回10的i次方
    static int power10(int i) {
        int res = 1;
        while (i -- > 0) res *= 10;
        return res;
    }
    
    static int count(int n, int x) {    //1-n中x出现的次数
        if (n <= 0) return 0;   //n <= 0
        
        List<Integer> num = new ArrayList<>();
        while (n != 0) {    //把n中每一位存到数组里
            num.add(n % 10);
            n /= 10;
        }
        
        n = num.size();     //n置为数组长度
        int res = 0;
        //从最高位开始统计x出现的次数, x=0则从次高位开始统计（边界条件）
        //i表示x当前处于哪一位
        for (int i = n - 1 - (x == 0 ? 1: 0); i >= 0; i -- ) {  
            //情况1
            if (i < n - 1) {
                res += get(num, n - 1, i + 1) * power10(i);
                if (x == 0) res -= 1 * power10(i);    //边界情况
            }
            
            //情况2.2
            if (num.get(i) == x) res += get(num, i - 1, 0) + 1;
            
            //情况2.3
            if (num.get(i) > x) res += power10(i);
        }
        
        return res;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int a = (int)ins.nval;
        ins.nextToken(); int b = (int)ins.nval;
        
        while (a != 0 || b != 0) {
            if (a > b) { int t = a; a = b; b = t; }
            
            for (int i = 0; i < 10; i ++)
                out.print((count(b, i) - count(a - 1, i)) + " ");
            out.println();
            
            ins.nextToken(); a = (int)ins.nval;
            ins.nextToken(); b = (int)ins.nval;
        }

        out.flush();
    }
}
