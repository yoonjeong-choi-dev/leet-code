    class Node {
        Node prev, next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class DLL {
        Node head, tail;

        public DLL() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public Node addLast(int val) {
            Node node = new Node(val);
            node.next = tail;
            node.prev = tail.prev;

            tail.prev.next = node;
            tail.prev = node;
            return node;
        }

        public int popLast() {
            return remove(tail.prev).val;
        }

        public int peekLast() {
            return tail.prev.val;
        }

        public Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }


    class MaxStack {

        private TreeMap<Integer, List<Node>> sortedMap;
        private DLL dll;

        public MaxStack() {
            sortedMap = new TreeMap<>();
            dll = new DLL();
        }

        public void push(int x) {
            if (!sortedMap.containsKey(x)) sortedMap.put(x, new ArrayList<>());
            Node node = dll.addLast(x);
            sortedMap.get(x).add(node);
        }

        public int pop() {
            int val = dll.popLast();
            List<Node> list = sortedMap.get(val);
            list.remove(list.size() - 1);
            if (list.isEmpty()) sortedMap.remove(val);
            
            return val;
        }

        public int top() {
            return dll.peekLast();
        }

        public int peekMax() {
            return sortedMap.lastKey();
        }

        public int popMax() {
            int val = peekMax();
            List<Node> list = sortedMap.get(val);
            Node toRemove = list.remove(list.size()-1);
            dll.remove(toRemove);
            if(list.isEmpty()) sortedMap.remove(val);
            
            return val;
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