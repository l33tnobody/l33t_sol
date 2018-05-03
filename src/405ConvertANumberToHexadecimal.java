class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while(num!=0) {
            int t = (num & 0xf);
            String ts = convert(t);
            sb.insert(0, ts);
            num >>>= 4;
        }

        return sb.toString();
    }

    private String convert(int n) {
        if (n < 10) return String.valueOf(n);
        if (n == 10) return "a";
        if (n == 11) return "b";
        if (n == 12) return "c";
        if (n == 13) return "d";
        if (n == 14) return "e";
        if (n == 15) return "f";
        return "";
    }
}
