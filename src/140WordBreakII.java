public class Solution {
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();

        if(s.length()==0) {
            res.add("");
            return res;
        }
        for(int i=0; i<s.length(); i++){
            String word = s.substring(i); // from i onward, inclusive.
            if(wordDict.contains(word)){
                String before = s.substring(0, i);
                res.addAll(combine(wordBreak(before, wordDict), word));
            }
        }
        map.put(s, res);
        return res;
    }

    private List<String> combine(List<String> list, String word){
        List<String> res = new ArrayList<>();
        for(String s : list){
            res.add( !s.equals("") ? s+" "+word : word );
        }
        return res;
    }
}

// Time Limit Exceeded for OJ if commented out section not included
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int len = s.length();

// ############### only need this section to pass online judge
        boolean[] table = new boolean[len+1];
        table[0]=true;

        for(int i=1; i<=len; i++) {
            for(int j=0; j<i; j++) {
                if (table[j] && wordDict.contains(s.substring(j+1-1, i-1+1))) {
                    table[i] = true;
                    break;
                }
            }
        }

        if (table[len] == false) return new ArrayList<String>();
// ###############

        List<List<String>> results = new ArrayList<List<String>>(len+1);
        for(int i=0; i<len+1; i++){
            results.add(new ArrayList<String>());
        }
        results.get(0).add(""); // result for an empty String s

        for(int i=1; i<=len; i++){
            for(int j=0; j<i; j++){
                String word = s.substring(j+1-1, i-1+1);
                if(results.get(j).size()!=0 && wordDict.contains(word)){
                    for(String res : results.get(j)){
                        results.get(i).add( (res!="") ? res+" "+word : word );
                    }
                }
            }
        }

        return results.get(len);
    }
}


// Dictionary based solution
public List<String> wordBreak(String s, Set<String> wordDict) {
    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
}

// DFS function returns an array including all substrings derived from s.
List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
    if (map.containsKey(s))
        return map.get(s);

    LinkedList<String>res = new LinkedList<String>();
    if (s.length() == 0) {
        res.add("");
        return res;
    }
    for (String word : wordDict) {
        if (s.startsWith(word)) {
            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
            for (String sub : sublist)
                res.add(word + (sub.isEmpty() ? "" : " ") + sub);
        }
    }
    map.put(s, res);
    return res;
}
