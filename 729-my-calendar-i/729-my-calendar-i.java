class MyCalendar {

    private List<int[]> booked = new ArrayList<>(1000);

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            boolean ans = true;
            for (int[] b : booked) {
                // 유효한 범위 : end <= b[0] || b[1] <= start
                if(end > b[0] && b[1] >start) {
                    ans = false;
                    break;
                }
            }

            if (ans) {
                booked.add(new int[]{start, end});
            }

            return ans;
        }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */