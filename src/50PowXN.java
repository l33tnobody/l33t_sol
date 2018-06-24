public class Solution {
    public double pow(double x, int n) {
        long longn=(long) n; // prevent Integer.MIN_VALUE from overflow
        if(x==0){
            if(longn==0) return 1;
            return 0;
        }

        if(longn==0){
            return 1;
        }

        boolean nneg=false;
        if(longn<0) {nneg=true;longn=-longn;}

        double res=1;
        double temp=x;
        while(longn>1){
            if(longn%2==1) res*=temp;
            temp*=temp;//square 2
            longn>>=1;   //n/=2
        }
        res*=temp;

        return nneg ? 1.0/res : res;
    }
}
