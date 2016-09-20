/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private char[] ibuf = new char[4];
    private int ibufPtr = 0;
    private int ibufCount = 0;

    public int read(char[] buf, int n) {
        int ptr=0;

        while(ptr<n) {
            if(ibufPtr==0){
                ibufCount = read4(ibuf);
            }
            if (ibufCount==0) // EOF
                break;
            for(;ptr<n && ibufPtr<ibufCount; ptr++, ibufPtr++){
                buf[ptr] = ibuf[ibufPtr];
            }

            if(ibufPtr == ibufCount)
                ibufPtr = 0; // to prepare to start to read again.
        }
        return ptr;
    }
}
