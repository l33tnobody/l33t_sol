public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long num = (long)numerator;
        long denom = (long)denominator;

        String sign="";
        if ( (num>0 && denom<0) || (num<0 && denom>0) ) sign="-";

        sb.insert(0, sign);
        num = Math.abs(num);
        denom = Math.abs(denom);

        long d = num/denom;
        long r = num%denom;
        sb.append(d);

        if (r==0) return sb.toString();

        sb.append(".");
        // map from remainder to a position in the quotient
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        while(r!=0) {
            r *= 10;
            if (map.containsKey(r)) {
                paren(sb, map.get(r));
                break;
            } else {
                map.put(r, sb.length());
            }
            d = r/denom;
            r = r%denom;
            sb.append(d);
        }

        return sb.toString();
    }

    private void paren(StringBuilder sb, int i) {
        sb.insert(i, '(');
        sb.append(')');
    }
}

// draft: see more readable final version above
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        // map from remainder to a position in the quotient
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        long num = (long)numerator;
        long denom = (long)denominator;

        String sign="";
        // if (num * denom < 0) sign="-";
        if ( (num>0 && denom<0) || (num<0 && denom>0) ) sign="-";
        num = Math.abs(num);
        denom = Math.abs(denom);

        long d = num/denom;
        long r = num%denom;
        sb.append(d);
        if (r!=0) sb.append(".");
        // int i = sb.length();

        while(r!=0) {
            r *= 10;
            if (map.containsKey(r)) {
                paren(sb, map.get(r));
                break;
            } else {
                // map.put(r, i);
                map.put(r, sb.length());
            }
            d = r/denom;
            r = r%denom;
            sb.append(d);
            // i++;
        }

        sb.insert(0, sign);
        return sb.toString();
    }

    private void paren(StringBuilder sb, int i) {
        sb.insert(i, '(');
        sb.append(')');
    }
}
