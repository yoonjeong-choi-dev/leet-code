class Node {
    int key;
    int val;
    Node prev, next;
    
    Node() {
        key = -1;
        val = -1;
    }
    
    Node(int key ,int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    
    private Map<Integer, Node> cache;
    private Node head, tail;
    private int capacity,size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node target = cache.getOrDefault(key, null);
        if(target == null) return -1;
        
        updateCache(target);
        return target.val;
    }
    
    public void put(int key, int value) {
        Node target = cache.getOrDefault(key, null);
        
        if(target == null) {
            target = new Node(key ,value);
            addCacheData(target);
        } else {
            target.val = value;
            updateCache(target);
        }
    }
    
    private void addCacheData(Node node) {
        
        if(capacity == size) removeLastCache();
        
        // head -> node -> head.next
        head.next.prev = node;
        node.next = head.next;
        
        head.next = node;
        node.prev = head;
        
        cache.put(node.key, node);
        
        size++;
    }
    
    private void updateCache(Node node) {
        removeCacheData(node);
        addCacheData(node);
    }
    
    private void removeCacheData(Node node) {
        // node.prev -> node.next
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        cache.remove(node.key);
        
        size--;
    }
    
    private void removeLastCache() {
        Node toRemove = tail.prev;
        if(head != toRemove) removeCacheData(toRemove);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */