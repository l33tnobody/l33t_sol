// my version not very pretty
class Solution {
    public int compress(char[] chars) {
        // if (chars.length == 0) return 0;

        int i = 0, j = 0;
        int count = 0;

        while(j < chars.length) {
            if(chars[j] == chars[i]) {
                count++;
                j++;
            } else {
                if (count > 1) { // len 2 will be equal and above save len
                    String s = String.valueOf(count);
                    i++;
                    writeChar(s, chars, i);
                    i += s.length();
                } else { // == 1
                    i++;
                }
                chars[i] = chars[j];
                count = 0;
            }
        }

        if (count > 1) {
            String s = String.valueOf(count);
            i++;
            writeChar(s, chars, i); // this function pushes i as well
            i += s.length();
        } else if (count == 1){
            i++;
        }

        return i;
    }

    private void writeChar(String s, char[] chars, int i) {
        for(int k=0; k<s.length(); k++) {
            chars[i+k] = s.charAt(k);
        }
    }
}

// a much prettier version
class Solution {
    public int compress(char[] chars) {
        int i=0, j=0;
        while(j < chars.length) {
            char curchar = chars[j];
            int count = 0;
            while(j < chars.length && chars[j] == curchar) {
                count++;
                j++;
            }
            chars[i++] = curchar;
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) {
                    chars[i++] = c;
                }
            }
        }
        return i;
    }
}
