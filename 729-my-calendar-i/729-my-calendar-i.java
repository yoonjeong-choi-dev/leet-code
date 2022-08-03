class MyCalendar {
    
    // key : start, value: end
    private TreeMap<Integer, Integer> books;

    public MyCalendar() {
        books = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = books.floorKey(start);
        Integer nextStart = books.ceilingKey(start);
        
        if(prevStart != null && start < books.get(prevStart)) return false;
        if(nextStart != null && nextStart < end) return false;
        
        books.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */