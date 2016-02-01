public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, LinkedList<String>>hm=new HashMap<String, LinkedList<String>>();
        ArrayList<String> res=new ArrayList<String>();
        for(String word : strs){
            String key=sortChars(word);
            if(!hm.containsKey(key))    hm.put(key, new LinkedList<String>());
            hm.get(key).add(word);
        }
        
        for(String key : hm.keySet()){
            LinkedList list=hm.get(key);
            if(list.size()>1)
                res.addAll(list);
        }
        
        return res;
    }
    
    private String sortChars(String ostr){
        char[] ca=ostr.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }
}
