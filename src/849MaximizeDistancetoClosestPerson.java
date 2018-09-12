// clearer two pointers:
class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev1 = -1, max = 0, n = seats.length;
        
        for(int i=0; i<n; i++) {
            if(seats[i] == 0) continue;
            
            if(prev1 == -1) max = i - 0;
            else {
                max = Math.max(max, (i - prev1) / 2);
            }
            prev1 = i;
        }
        
        if(seats[n - 1] == 0) max = Math.max(max, n - 1 - prev1);
        
        return max;
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int first1 = -1, last1 = -1, n = seats.length;
        for(int i=0; i<n; i++) {
            if(seats[i] == 1) { first1 = i; break; }
        }
        for(int j=n-1; j>=0; j--) {
            if(seats[j] == 1) { last1 = j; break; }
        }
        
        int max = 0;
        if(first1 != 0) max = first1 - 0; 
        if(last1 != n-1 && n - 1 - last1 > max) max = n - 1 - last1;
        
        int prev1 = first1;
        for(int i = first1 + 1; i<=last1; i++) {
            if(seats[i] == 1) {
                if(i - prev1 > 1) { // possibly 0 in the middle
                    int distance = (i-prev1)/2; // drew example, easy to see
                    if(distance > max) max = distance;
                }
                prev1 = i;
            }
        }
        
        return max;
    }
}