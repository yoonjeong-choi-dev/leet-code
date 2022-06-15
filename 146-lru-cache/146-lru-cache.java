class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    class LRUCache {

        private final int capacity;
        private final Map<Integer, Node> cache;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.getOrDefault(key, null);
            if (node == null) return -1;

            // 현재 노드를 가장 앞으로 이동
            // 1) node 전후 노드 연결
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;

            // 2) node 헤드로 이동
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.getOrDefault(key, null);

            if (node != null) {
                // 이미 캐시에 있는 경우 => 값 및 캐시 업데이트
                node.value = value;

                // 캐시 업데이트
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;

                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;

            } else {
                // 캐시에 없는 경우 => 노드 추가
                node = new Node(key, value);

                // 캐시 용량이 부족한 경우에는 가장 뒷부분 삭제
                if(cache.size() == capacity) {
                    // 캐시에서 가장 뒷 부분 삭제
                    Node toDelete = tail.prev;
                    Node prev = toDelete.prev;
                    prev.next = tail;
                    tail.prev = prev;

                    cache.remove(toDelete.key);
                }

                // 노두 추가
                cache.put(key, node);

                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;

            }
        }
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */