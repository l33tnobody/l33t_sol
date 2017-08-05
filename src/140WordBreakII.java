// Dictionary based solution
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }

    List<String> DFS(String s, List<String> wordDict, HashMap<String, List<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        List<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map); // can be empty if not able to break down.
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
            // or:
            // if (s.endsWith(word)) {
            //     List<String> sublist = DFS(s.substring(0, s.length() - word.length()), wordDict, map); // can be empty if not able to break down.
            //     for (String sub : sublist)
            //         res.add(sub.isEmpty() ? word : sub + " " + word);
            // }
        }

        map.put(s, res);
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

// dict based iterative dp:
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        List<List<String>> results = new ArrayList<>(len+1);
        for(int i=0; i<len+1; i++){
            results.add(new ArrayList<String>());
        }
        results.get(0).add(""); // result for an empty String s

        for(int i=1; i<=len; i++) {
            for(String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && results.get(j).size() != 0 && word.equals(s.substring(j+1-1, i-1+1))) {
                    for(String str : results.get(j)) {
                        results.get(i).add( (str=="") ? word : str + " " + word);
                    }
                }
            }
        }
        return results.get(len);
    }
}
