// group anagrams by their unique key: etc. a1b2, can use index of chars instead of chars
// time O(nk), n strings and k is average length of a string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            String key = getKey(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
        for(String k : map.keySet()) {
            res.add(map.get(k));
        }
        
        return res;
    }
    
    private String getKey(String s) { // get identifying key for anagrams, O(k) given average length k of a string
        StringBuilder sb = new StringBuilder();
        char[] count = new char[26];
        
        for(char c : s.toCharArray()) count[c - 'a']++;
        for(int i=0; i<count.length; i++) {
            if(count[i] == 0) continue;
            
            sb.append(i).append("-").append(count[i]).append("#");
        }
        return sb.toString();
    }

    // private String getKey(String s) { sort is O(klogk) given average length k of a string
    //     char[] arr = s.toCharArray();
    //     Arrays.sort(arr);
    //     return String.valueOf(arr); // or return new String(arr);
    // }
}