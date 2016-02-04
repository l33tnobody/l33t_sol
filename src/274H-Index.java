public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i=0; i<len; i++){
            if (citations[i]>=len-i)
                return len-i;
        }
        return 0;
    }
}


// time O(n), space O(n)
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int [] count = new int[len+1]; // 0 ~ N possible h index

        for (int c : citations){
            if (c>len) count[len]++;
            else count[c]++;
        }

        int t=0;
        for (int i=len; i>=0; i--){
            t+=count[i];
            if (t >= i) // max h reached here. when t==i
                return i;
        }
        return 0;
    }
}
