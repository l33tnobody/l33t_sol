public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=S.length();
        int wlen=L[0].length();
        HashMap<String, Integer> words = new HashMap<String, Integer>();
     
        for ( String s:L ) {
            if ( words.containsKey( s ) ){
                words.put( s, 1+words.get(s) );
            } else 
                words.put( s, 1 );
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<=n-wlen*L.length;i++) {
            HashMap<String, Integer> need=new HashMap<String, Integer>(words);
            for(int p=i;;p+=wlen){
                String sub = S.substring(p,p+wlen);
                if(!need.containsKey(sub)) break;
                if(need.get(sub)==1)    need.remove(sub);
                else need.put(sub, need.get(sub)-1);
                if(need.isEmpty())  {res.add(i); break;}
            }
        }
        
        return res;
    }
}
