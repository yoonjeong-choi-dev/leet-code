    class MaxStack {

        private Stack<Integer> stack;
        private Stack<Integer> maxStack;

        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

            if (maxStack.isEmpty() || x >= maxStack.peek()) maxStack.push(x);
        }

        public int pop() {
            int ret = stack.pop();
            if (maxStack.peek() == ret) maxStack.pop();
            return ret;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int ret = maxStack.pop();

            Stack<Integer> temp = new Stack<>();
            while (stack.peek() != ret) temp.push(stack.pop());
            stack.pop();
            
            while(!temp.isEmpty()) this.push(temp.pop());
            
            return ret;
        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */