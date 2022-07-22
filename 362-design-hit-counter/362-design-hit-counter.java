class HitCounter {

        private static final int TERM = 300;
        private final Queue<Integer> queue;

        public HitCounter() {
            queue = new ArrayDeque<>();
        }

        public void hit(int timestamp) {
            queue.add(timestamp);
        }

        public int getHits(int timestamp) {
            int lastTime = timestamp - TERM;
            while (!queue.isEmpty()) {
                if (queue.peek() <= lastTime) queue.poll();
                else break;
            }

            return queue.size();
        }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */