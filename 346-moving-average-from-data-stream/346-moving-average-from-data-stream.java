class MovingAverage {

        private int capacity;
        private Queue<Integer> queue;
        private int curSum;

        public MovingAverage(int size) {
            capacity = size;
            queue = new ArrayDeque<>(size);
            curSum = 0;
        }

        public double next(int val) {
            if (queue.size() == capacity) {
                curSum -= queue.poll();
            }

            queue.add(val);
            curSum += val;

            return (double) curSum / queue.size();
        }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */