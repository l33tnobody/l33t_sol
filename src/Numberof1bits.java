public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}



public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        int bit=1;

        for(int i=0; i<32; i++){
            if(isOne(n, bit))
                count++;
            bit<<=1;
        }
        return count;
    }

    private boolean isOne(int n, int bit){
        return (n&bit) != 0;
    }

}