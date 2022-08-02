    class LogSystem {

        private Map<String, Integer> granularityIndexMap = new HashMap<String, Integer>() {{
            put("Year", 0);
            put("Month", 1);
            put("Day", 2);
            put("Hour", 3);
            put("Minute", 4);
            put("Second", 5);
        }};

        // int[] : (year,month,day,hour,minute, second)
        private final Map<Integer, int[]> log = new HashMap<>();

        public LogSystem() {

        }

        public void put(int id, String timestamp) {
            log.put(id, parseToInt(timestamp));
        }

        private int[] parseToInt(String timestamp) {
            String[] token = timestamp.split(":");
            int[] timestampArr = new int[token.length];
            for (int i = 0; i < token.length; i++) {
                timestampArr[i] = Integer.parseInt(token[i]);
            }

            return timestampArr;
        }

        public List<Integer> retrieve(String start, String end, String granularity) {
            List<Integer> ans = new ArrayList<>();

            int granularityIndex = granularityIndexMap.get(granularity);
            int[] startTime = parseToInt(start);
            int[] endTime = parseToInt(end);

            int[] timestamp;
            for (int id : log.keySet()) {
                timestamp = log.get(id);
                if (isAfter(startTime, timestamp, granularityIndex) && isAfter(timestamp, endTime, granularityIndex))
                    ans.add(id);
            }

            return ans;
        }

        private boolean isAfter(int[] t1, int[] t2, int targetIdx) {
            boolean ret = true;
            for (int i = 0; i <= targetIdx; i++) {
                if (t1[i] < t2[i]) break;
                else if (t1[i] > t2[i]) {
                    ret = false;
                    break;
                }
            }
            return ret;
        }
    }
/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */