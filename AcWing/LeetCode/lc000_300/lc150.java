package AcWing.LeetCode;        //150. 逆波兰表达式求值

class Solution {        //模板题 + 栈 + 时间复杂度O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i ++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {     //是运算符
                int b = stk.pop(), a = stk.pop();   //取出进行运算的两个数, 注意顺序
                if (s.equals("+")) a += b;
                else if (s.equals("-")) a -= b;
                else if (s.equals("*")) a *= b;
                else a /= b;
                stk.push(a);
            }
            else stk.push(Integer.valueOf(s));      //是数字
        }

        return stk.peek();      //返回栈顶元素
    }
}