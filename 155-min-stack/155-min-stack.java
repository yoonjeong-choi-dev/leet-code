class MinStack {

    private Stack<Integer> main;
    private Stack<Integer> minStack;
    
    public MinStack() {
        main = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        
        if(minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int ret = main.pop();
        
        if(minStack.peek() == ret) minStack.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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