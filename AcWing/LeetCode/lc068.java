package AcWing.LeetCode;

class Solution {    //模拟 + 思维题
    public List<String> fullJustify(String[] wds, int mw) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wds.length; i++) {
            int j = i + 1;  //j从下一个单词开始
            int len = wds[i].length();  //当前行的长度
            //计算当前行能放入多少个单词，初始时每个单词间先加入一个空格 
            while (j < wds.length && len + 1 + wds[j].length() <= mw)    //注意判断条件
                len += 1 + wds[j++].length();

            String line = wds[i];   //先将第一个单词放入line
            if (j == wds.length || j == i + 1) {    //最后一行or当前行只能放一个单词，左对齐
                for (int k = i + 1; k < j; k++) line += ' ' + wds[k];   //最后一行
                while (line.length() < mw) line += ' ';     //左端补上空格
            }
            else {  //左右对齐
                //cnt代表该行中的间隙个数，r代表能用的空格数量
                int cnt = j - i - 1, r = mw - len + cnt;
                int k = 0;  //前r % cnt个缝隙的空格数为 r/cnt+1个
                while (k < r % cnt) {
                    line += sspace(r / cnt + 1) + wds[i + k + 1];
                    k++;    //更新k
                }
                while (k < cnt) {
                    line += sspace (r / cnt) + wds[i + k + 1]; k++;
                }
            }
            i = j - 1;  //更新i

            res.add(line);  //将当前行加入答案中            
        }

        return res;
    }

    String sspace(int n) {  //产生n个空格组成的字符串
        String s = "";
        for (int i = 0; i < n; i++) s += ' ';
        return s;
    }
}
