public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();

        int len = s.length();
        if (len<10)
            return result;

        Set<Integer> first = new HashSet<Integer>();
        Set<Integer> second = new HashSet<Integer>();
        int hash=0;
        int mask = (1<<20) - 1;
        // rolling hash
        for(int i=0; i<len; i++) {
            hash = (hash<<2) + getNumber(s.charAt(i));
            if (i<9)
                continue;

            hash &= mask;
            if (!first.add(hash) && second.add(hash)) // only add once when seen the second time, dedup
                result.add(s.substring(i-9, i+1));
        }
        return result;
    }

    private int getNumber(char c) { //two bits
        if (c=='A'){
            return 0;
        } else if (c=='C'){
            return 1;
        } else if (c=='G'){
            return 2;
        } else if (c=='T'){
            return 3;
        }
        return -1;
    }
}

// or simply:
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len<10)
            return new ArrayList<String>();
        
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if(i<9) continue;
            
            String cand = sb.toString();
            if(!seen.contains(cand)) seen.add(cand);
            else res.add(cand);
            sb.deleteCharAt(0);
        }
        
        return new ArrayList(res);
    }
}