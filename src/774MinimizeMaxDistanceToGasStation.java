class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 0;
        for(int i = 0; i < stations.length - 1; i++) {
            hi = Math.max(hi, stations[i+1] - stations[i]);
        }
        
        while(hi - lo > 0.000001) {
            double mi = (lo + hi) / 2;
            int count = 0;
            for(int i = 0; i < stations.length - 1; i++) {
                count += Math.ceil((stations[i+1] - stations[i]) / mi) - 1; // at least this many additional gas stations between i and i+1
            }
            if(K < count) lo = mi;
            else hi = mi;
        }
        
        return hi;
    }
}