    class StringIterator {

        private String compressedString;
        private char curChar;
        private int curCount, curIdx, len;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
            len = compressedString.length();
            curIdx = 0;
            update();
        }

        private void update() {
            if(curIdx == len) return;
            
            curChar = compressedString.charAt(curIdx++);
            StringBuilder sb = new StringBuilder();
            while (curIdx < len && Character.isDigit(compressedString.charAt(curIdx))) {
                sb.append(compressedString.charAt(curIdx++));
            }
            curCount = Integer.parseInt(sb.toString());

        }

        public char next() {
            if (!hasNext()) return ' ';

            char ret = curChar;
            curCount--;

            if (curCount == 0) update();

            return ret;
        }

        public boolean hasNext() {
            return curCount != 0;
        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */