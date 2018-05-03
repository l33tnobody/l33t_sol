class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length; i++) {
            if((data[i] & 0x00000080) == 0) continue; // 0xxxxxxx

            // begin with 1
            if((data[i] & 0x00000040) == 0) return false; // no utf8 char begins with 10xx

            // 11xx xxxx
            int numfollow = 1;
            if((data[i] & 0x00000020) != 0) { // 111x xxxx
               if ((data[i] & 0x00000010) == 0) { // 1110 xxxx
                   numfollow=2;
               } else { // 1111 xxxx
                   if((data[i] & 0x00000008) != 0) return false; // only 1111 0xxx 3 10xxxxxx follows is valid, 1111 1xxx is invalid
                   numfollow=3;
               }
            }

            if (i+numfollow >= data.length) return false;
            for(int j = i+1; j <= i+numfollow; j++) {
                if((data[j] & 0x00000080) == 0 || (data[j] & 0x00000040) != 0) return false;
            }
            i+=numfollow;

        }
        return true;
    }
}
