class HitCounter {

        private static final int TERM = 300;
        private int count;

        // (timestamp, count)
        // timestamp is monotonically increasing). Several hits may arrive roughly at the same time.
        // => 함수 호출 시 큐의 첫 부분만 고려하면 됨
        private final Queue<int[]> queue;

        public HitCounter() {
            count = 0;
            queue = new ArrayDeque<>();
        }

        public void hit(int timestamp) {
            if (!queue.isEmpty() && queue.peek()[0] == timestamp) {
                queue.peek()[1]++;
            } else {
                queue.add(new int[]{timestamp, 1});
            }
            count++;
        }

        public int getHits(int timestamp) {
            int lastTime = timestamp - TERM;
            while (!queue.isEmpty()) {
                if (queue.peek()[0] <= lastTime) {
                    count -= queue.poll()[1];
                } else break;
            }
            return count;
        }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */