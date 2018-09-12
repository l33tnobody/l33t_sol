class Solution {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int i = 1;
        
        for(; i < n; i++) {
            if(A[i-1] <= A[i]) continue;
            else break;
        }
        if(i == n) return true;
        
        for(i = 1; i < n; i++) {
            if(A[i-1] >= A[i]) continue;
            else break;
        }
        if(i == n) return true;
        
        return false;
    }
}

// one pass:
class Solution {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int status = 0; // -1: < , 0: =, 1, >
        
        for(int i=0; i<n-1; i++) {
            int s = 0;
            if(A[i] < A[i+1]) s = -1;
            else if(A[i] > A[i+1]) s = 1;
            
            if(s != 0) { // s == 0 will not change any status
                if(status != 0 && status != s) return false;
                status = s;
            }
        }
        
        return true;
    }
}