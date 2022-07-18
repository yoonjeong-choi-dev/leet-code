/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int readRet = 4;
            int totalRead = 0;

            char[] buf4 = new char[4];
            while (totalRead < n && readRet == 4) {
                readRet = read4(buf4);

                for (int i = 0; i < readRet; i++) {
                    buf[totalRead++] = buf4[i];

                    // n 만큼 읽은 경우
                    if (totalRead == n) return n;
                }
            }

            return totalRead;
    }
}