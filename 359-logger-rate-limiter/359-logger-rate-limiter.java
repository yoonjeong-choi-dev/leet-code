class Logger {

        private static final int TERM = 10;
        private final Map<String, Integer> logTime = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!logTime.containsKey(message)) {
                logTime.put(message, timestamp);
                return true;
            } else {
                int availableTime = logTime.get(message) + TERM;
                if (timestamp >= availableTime) {
                    logTime.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            }
        }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */