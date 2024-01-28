package AcWing.LeetCode;        //155. 最小栈

class MinStack {    //线性DP + 优化（ 不必要）
    Stack<Integer> stk = new Stack<>();     //存储原栈
    Stack<Integer> f = new Stack<>();   //f表示前缀和最小值栈，利用单调性进行优化，是一个单调不增数组  

    public MinStack() {

    }
    
    public void push(int val) {
        stk.push(val);
        if (f.empty() || f.peek() >= val) f.push(val);  //维护f数组
    }
    
    public void pop() {
        int a = stk.pop();
        if (a <= f.peek()) f.pop();     //当a <= ft时，更新ft 
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {  
        return f.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
