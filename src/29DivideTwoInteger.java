class Solution {
    public int divide(int dividend, int divisor) {
        // System.out.println(Integer.MAX_VALUE + 1); == Integer.MIN_VALUE overflow
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean minus=false;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))
            minus=true;

        long d1=Math.abs((long)dividend); long d2=Math.abs((long)divisor);
        int res=0;
        while(d1>=d2){
            long de=d2;
            int unit=1;
            for(;d1>=de;de<<=1,unit<<=1){
                d1-=de;
                res+=unit;
            }
        }

        return minus? -res:res;
    }
}
