class Logger {

        private static final int TERM = 10;
        private final Map<String, Integer> logTime = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            int availableTime = logTime.getOrDefault(message, -TERM) + TERM;
            if(timestamp < availableTime) return false;
            
            logTime.put(message, timestamp);
            return true;
        }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */