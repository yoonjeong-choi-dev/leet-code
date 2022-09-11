    class ProductOfNumbers {

        private List<Integer> partialProduct, lastZeroIndex;

        public ProductOfNumbers() {
            partialProduct = new ArrayList<>();
            lastZeroIndex = new ArrayList<>();

            partialProduct.add(1);
            lastZeroIndex.add(-1);
        }

        public void add(int num) {
            if (num == 0) {
                partialProduct.add(1);
                lastZeroIndex.add(partialProduct.size()-1);
            } else {
                int lastIndex = partialProduct.size() - 1;
                partialProduct.add(num * partialProduct.get(lastIndex));
                lastZeroIndex.add(lastZeroIndex.get(lastIndex));
            }
        }

        public int getProduct(int k) {
            int lastIndex = partialProduct.size() - 1;
            int prevIdx = lastIndex - k;
            int lastZero = lastZeroIndex.get(lastIndex);
            if (prevIdx < lastZero) return 0;
            return partialProduct.get(lastIndex) / partialProduct.get(prevIdx);
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */