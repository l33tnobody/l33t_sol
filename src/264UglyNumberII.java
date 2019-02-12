// easier to understand:
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i=1; i<n; i++) {
            int next = Math.min(next2, Math.min(next3, next5));
            ugly[i] = next;

            if(next == next2){
                i2++;
                next2 = 2*ugly[i2];
            }
            if(next == next3){
                i3++;
                next3 = 3*ugly[i3];
            }
            if(next == next5){
                i5++;
                next5 = 5*ugly[i5];
            }
        }

        return ugly[n-1];
    }
}


// more generic
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 1, next3 = 1, next5 = 1;

        for (int i=0; i<n; i++) {
            int next = Math.min(next2, Math.min(next3, next5));
            ugly[i] = next;

            if(next == next2){
                next2 = 2*ugly[i2];
                i2++;
            }
            if(next == next3){
                next3 = 3*ugly[i3];
                i3++;
            }
            if(next == next5){
                next5 = 5*ugly[i5];
                i5++;
            }
        }

        return ugly[n-1];
    }
}
