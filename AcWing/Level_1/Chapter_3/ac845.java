package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac845 {    //八数码
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static Queue<String> q = new LinkedList<String>();
    static Map<String, Integer> d = new HashMap<String, Integer>();
    
    static int bfs(String st) {
        d.put(st, 0); q.offer(st);
        
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            String t = q.poll();
            
            if (t.equals("12345678x")) return d.get(t);
            
            int k = t.indexOf("x"), dist = d.get(t);
            int x = k / 3, y = k % 3;
            
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    char[] arr = t.toCharArray();
                    char tp = arr[k]; arr[k] = arr[3 * a + b]; arr[3 * a + b] = tp;
                    String str = new String(arr);
                    
                    if (d.get(str) == null) {   //保证队列一定会清空
                        q.offer(str);
                        d.put(str, dist+1);
                    }
                }
            }
            
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        String str = inb.readLine().replaceAll(" ", "");
        
        out.println(bfs(str));

        out.flush();
    }
}
