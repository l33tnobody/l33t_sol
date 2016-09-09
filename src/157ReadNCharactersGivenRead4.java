// a better solution
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char [] tempBuf = new char[4];
        int lastRead = 0;

        while(count<n) {
            lastRead = read4(tempBuf);
            for(int k=0; k<lastRead && count<n; k++){
                buf[count++] = tempBuf[k];
            }
            if (lastRead!=4) break;
        }

        return count;
    }
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int times = n/4; // max times
        int r = n%4;
        if (r != 0) {
            times++;
        }

        int count = 0;
        char [] tempBuf = new char[4];

        for(int i=0; i<times; i++) {
            int c = read4(tempBuf);
            for(int k=0; k<c && count<n; k++){
                buf[count++] = tempBuf[k];
            }
        }

        return count;
    }
}
