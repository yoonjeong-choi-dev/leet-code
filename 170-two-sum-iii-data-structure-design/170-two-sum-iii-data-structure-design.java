class TwoSum {

        private final Map<Integer, Integer> counters = new HashMap<>();

        public TwoSum() {

        }

        public void add(int number) {
            counters.put(number, counters.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            int remain;
            for (Integer num : counters.keySet()) {
                remain = value - num;

                if(remain == num) {
                    // 현재 숫자 *2 가 타겟인 경우 => 현재 숫자가 2번이상 저장되어야 참
                    if(counters.get(remain) > 1 ) return true;
                } else {
                    if(counters.containsKey(remain)) return true;
                }
            }
            
            return false;
        }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */