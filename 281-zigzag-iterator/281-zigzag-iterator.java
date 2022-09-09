public class ZigzagIterator {
    
    Iterator<Integer> cur, other;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        cur = v1.iterator();
        other = v2.iterator();
        
        if(!cur.hasNext()) swap();
    }

    public int next() {
        int ret = cur.next();
        
        if(other.hasNext()) swap();
        return ret;
    }

    public boolean hasNext() {
        return cur.hasNext();
    }
    
    private void swap() {
        Iterator<Integer> temp = cur;
        cur = other;
        other = temp;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */