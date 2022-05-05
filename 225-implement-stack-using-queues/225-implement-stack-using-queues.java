class MyStack {

        private final Queue<Integer> store1 = new LinkedList<>();
        private final Queue<Integer> store2 = new LinkedList<>();
        private Queue<Integer> curStack, curStore;

        public MyStack() {
            curStack = store1;
            curStore = store2;
        }

        public void push(int x) {

            if (!curStack.isEmpty()) {
                while (!curStack.isEmpty()) {
                    curStore.add(curStack.poll());
                }
            }
            curStack.add(x);
        }

        public int pop() {
            int ret = curStack.poll();
            while (curStore.size() > 1) {
                curStack.add(curStore.poll());
            }

            Queue<Integer> temp = curStack;
            curStack = curStore;
            curStore = temp;

            return ret;
        }

        public int top() {
            return curStack.peek();
        }

        public boolean empty() {
            return store1.isEmpty() && store2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */