package AcWing.LeetCode;

class Solution {    //模拟+思维题+双指针+扫描
    public boolean isNumber(String s) {
        int l = 0, r = s.length() - 1;
        //去掉前后空格
        while (l <= r && s.charAt(l) == ' ') l++;
        while (l <= r && s.charAt(r) == ' ') r--;
        if (l > r) return false;
        s = s.substring(l, r + 1);  //更新s为s[l, r]
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);   //去掉前导+-
        if (s.length() == 0) return false;

        //当.出现在最前面，如果只有点or其后为e，返回false
        if (s.charAt(0) == '.' && (s.length() == 1 || s.charAt(1) == 'e' || s.charAt(1) == 'E')) 
            return false;

        int dot = 0 , e = 0;    //dot表示.出现的次数，e表示e出现的次数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                //点已经出现过或者点出现在e之后，返回false
                if (dot > 0 || e > 0) return false;
                dot++;  
            }
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                //e出现在最前，e出现在最后，e已经出现过，返回false
                if (i == 0 || i + 1 == s.length() || e > 0) return false;
                //e后一个字符为+or-时，其不能为最后一个
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (i + 2 == s.length()) return false;
                    i++;    //跳过下一个+或者-
                }
                e++;    //更新e的数量    
            }
            //当前字符不是数字，返回false
            else if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }

        return true;   
    }
}
