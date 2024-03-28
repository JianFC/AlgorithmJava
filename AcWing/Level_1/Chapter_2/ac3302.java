package AcWing.Level_1.Chapter_2;      //AcWing 3302. 表达式求值

import java.io.*;
import java.util.*;

public class ac3302 {   
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    //使用两个栈模拟表达式树的计算方式
    //表达式树：叶结点为数，其余结点为计算符，且符号优先级随深度增加保持严格单调递增
    static int tt1, tt2;
    static int[] num = new int[N];  //数字栈
    static char[] op = new char[N]; //表达式栈
    
    static void eval() {
        int b = num[tt1 --];
        int a = num[tt1 --];
        char c = op[tt2 --];
        
        int x = 0;
        if (c == '+') x = a + b;
        else if (c == '-') x = a - b;
        else if (c == '*') x = a * b;
        else if (c == '/') x = a / b;
        
        num[++ tt1] = x;
    }

    public static void main(String[] args) throws Exception {
        String str = inb.readLine();
        
        Map<Character, Integer> pr = new HashMap<Character, Integer>();
        pr.put('+', 1); pr.put('-', 1); pr.put('*', 2); pr.put('/', 2);
        
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j)))
                    x = x * 10 + str.charAt(j++)-'0';
                i = j - 1;
                num[++ tt1] = x;
            }
            else if (c == '(') op[++ tt2] = c;
            else if (c == ')') {
                while (op[tt2] != '(') eval();
                tt2 --;
            }
            else {
                //注意是>=，而非>，从而保持符号优先级严格递增
                while (tt2 > 0 && op[tt2] != '(' && pr.get(op[tt2]) >= pr.get(c)) eval();  
                op[++ tt2] = c;
            }
        }
        
        while (tt2 > 0) eval();
        
        out.print(num[tt1]);
        
        out.flush();
    }
}
