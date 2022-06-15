class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>(n);
        boolean isThree, isFive;

        for (int i = 1; i <= n; i++) {
            isThree = i % 3 == 0;
            isFive = i % 5 == 0;
            if (isThree && isFive) ans.add("FizzBuzz");
            else if (isThree) ans.add("Fizz");
            else if (isFive) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }

        return ans;
    }
}