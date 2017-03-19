// 49. group anagrams
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                List<String> l = new ArrayList<String>();
                map.put(key, l);
            }
            map.get(key).add(s);
        }

        for (String k : map.keySet()) {
            res.add(map.get(k));
        }

        return res;
    }

    private String getKey(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    // O(n) way
    // private String getKey(String s) {
    //     int[] occurance = new int[26];
    //     String res = "";
    //
    //     for(int i=0; i<s.length(); i++) {
    //         occurance[s.charAt(i) - 'a']++;
    //     }
    //     for(int i=0; i<26; i++) {
    //         res += occurance[i] + "-";
    //     }
    //
    //     return res;
    // }
    // private String getKey(String s) {
    //     int[] occurance = new int[26];
    //     String res = "";
    //
    //     for(int i=0; i<s.length(); i++) {
    //         occurance[s.charAt(i) - 'a']++;
    //     }
    //     for(int i=0; i<26; i++) {
    //         if (occurance[i] == 0) continue;
    //         res += ('a' + i ) + "" + occurance[i];
    //     }
    //
    //     return res;
    // }
    //
}

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
