class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();
        long num = ip2num(ip);
        while(n > 0) {
            int i = 0; // subnet suffix
            int j = 1; // mask starts at
            while((num & j) == 0 && j <= n/2) { // find the highest '1' possible, without exceeding n
                i++;
                j <<= 1;
            }
            res.add(num2ip(num) + "/" + Integer.toString(32-i));
            num += j;
            n -= j;
        }

        return res;
    }

    private long ip2num(String ip) {
        String[] iparr = ip.split("\\.");
        long res = 0;
        for(int i=0; i < 4; i++) {
            res = res * 256 + Integer.parseInt(iparr[i]);
        }
        return res;
    }

    private String num2ip(long num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++) {
            if(i > 0) sb.insert(0, '.');
            sb.insert(0, (num & 255));
            num >>= 8;
        }
        return sb.toString();
    }
}
