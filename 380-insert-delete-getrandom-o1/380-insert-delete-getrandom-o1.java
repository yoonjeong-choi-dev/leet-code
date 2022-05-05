class RandomizedSet {

    private final Map<Integer, Integer> valToIndex = new HashMap<>();
        private final List<Integer> array = new ArrayList<>();
        private final Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) return false;

            valToIndex.put(val, array.size());
            array.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) return false;

            // 삭제할 요소 위치에 가장 마지막 요소 교환
            int removeIdx = valToIndex.get(val);
            int lastVal = array.get(array.size() - 1);
            array.set(removeIdx, lastVal);
            valToIndex.put(lastVal, removeIdx);

            // 마지막 요소 삭제
            array.remove(array.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            int randIdx = random.nextInt(array.size());
            return array.get(randIdx);
        }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */