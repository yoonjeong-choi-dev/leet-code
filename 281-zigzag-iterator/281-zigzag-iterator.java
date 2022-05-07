public class ZigzagIterator {

    Iterator<Integer> itr1, itr2, cur, other;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            itr1 = v1.iterator();
            itr2 = v2.iterator();

            if (itr1.hasNext()) {
                cur = itr1;
                other = itr2;
            } else {
                cur = itr2;
                other = itr1;
            }
        }

        public int next() {
            int ret = cur.next();
            if (other.hasNext()) {
                Iterator<Integer> temp = cur;
                cur = other;
                other = temp;
            }
            return ret;
        }

        public boolean hasNext() {
            return cur.hasNext();
        }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */