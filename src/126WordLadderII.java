[ // wrong output
["magic","manic","mania","maria","maris","paris","parks","perks","peaks","pears","pearl"],
["magic","manic","mania","maria","marta","marty","marry","parry","perry","peary","pearl"],
["magic","manic","mania","maria","marta","marty","marry","merry","perry","peary","pearl"],
["magic","manic","mania","maria","marta","marty","party","parry","perry","peary","pearl"]
]

[ // a word in a path may have multiple parents
["magic","manic","mania","maria","maris","paris","parks","perks","peaks","pears","pearl"],
["magic","manic","mania","maria","marta","marty","marry","parry","perry","peary","pearl"],
["magic","manic","mania","maria","marta","marty","marry","merry","perry","peary","pearl"],
["magic","manic","mania","maria","marta","marty","party","parry","perry","peary","pearl"],
["magic","manic",   "mania"     ,"maria"      ,"maris"     ,"marks",     "parks",      "perks",     "peaks",   "pears","pearl"]
]

// much better solution: build a single graph of words while doing two-ended search,
// and then DFS to find begin->end
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();

        if (beginWord == endWord) { // otherwise there is going to be duplication: word len of times.
            List<String> only = Arrays.asList(beginWord, endWord);
            res.add(only);
            return res;
        }

        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        boolean forward = true;

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // keep balance of begin and end set
            if(beginSet.size()>endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                forward = !forward;
            }

            boolean done = false;

            Set<String> neighbors = new HashSet<String>();
            for (String w : beginSet) {
                char[] arr = w.toCharArray();
                for (int i=0; i<arr.length; i++) {
                    char orig = arr[i];
                    for(char c='a'; c<='z';c++) {
                        arr[i] = c;
                        String target = String.valueOf(arr);
                        if (endSet.contains(target)){
                            addToMap(w, target, map, forward);
                            done = true;
                        } else if (wordList.contains(target) || neighbors.contains(target)){
                            neighbors.add(target);
                            wordList.remove(target);
                            addToMap(w, target, map, forward);
                        }
                    }
                    arr[i] = orig;
                }
            }
            if (done) return genResult(res, map, beginWord, endWord);

            beginSet = neighbors;
        }

        return res; // empty result
    }

    private void addToMap(String w, String target, HashMap<String, List<String>> map, boolean forward){
        if(!forward){
            String temp = w;
            w = target;
            target = temp;
        }

        List<String> l;
        if (map.containsKey(w)) {
            l = map.get(w);
        } else {
            l = new ArrayList<String>();
        }
        l.add(target);
        map.put(w, l);
    }

    private List<List<String>> genResult(List<List<String>> res, HashMap<String, List<String>> map, String begin, String end){
        ArrayList<String> running = new ArrayList<String>();
        dfs(res, running, map, begin, end);
        return res;
    }

    private void dfs(List<List<String>> res, ArrayList<String> running, HashMap<String, List<String>> map, String begin, String end){
        running.add(begin);
        if (begin.equals(end)) {
            res.add((List<String>)running.clone());
            return;
        }
        if (!map.containsKey(begin)) return;

        for(String next : map.get(begin)){
            dfs(res, running, map, next, end);
            running.remove(running.size()-1);
        }
    }
}





// the paths are a graph of words, break paths in the matching middle: coding is too complicated.
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<String[]> pairs = new ArrayList<String[]>();
        List<List<String>> res = new ArrayList<List<String>>();

        if (beginWord == endWord) {
            List<String> only = Arrays.asList(beginWord, endWord);
            res.add(only);
            return res;
        }

        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // keep balance of begin and end set
            if(beginSet.size()>endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            boolean done = false;

            Set<String> neighbors = new HashSet<String>();
            for (String w : beginSet) {
                char[] arr = w.toCharArray();
                for (int i=0; i<arr.length; i++) {
                    char orig = arr[i];
                    for(char c='a'; c<='z';c++) {
                        arr[i] = c;
                        String target = String.valueOf(arr);
                        if (endSet.contains(target)){
                            String[] newpair = new String[] {w, target};
                            pairs.add(newpair);
                            done = true;
                        } else if (wordList.contains(target) || neighbors.contains(target)){
                            neighbors.add(target);
                            wordList.remove(target);
                            List<String> l;
                            if (map.containsKey(target)) {
                                l = map.get(target);
                            } else {
                                l = new ArrayList<String>();
                            }
                            l.add(w);
                            map.put(target, l);
                        }
                    }
                    arr[i] = orig;
                }
            }
            if (done) return genResult(pairs, res, map, beginWord, endWord);

            beginSet = neighbors;
        }

        return res; // empty result
    }

    private List<List<String>> genResult(List<String[]> pairs, List<List<String>> res, HashMap<String, List<String>> map, String begin, String end){
        for (String[] sp : pairs) {
            res.addAll(flatten(sp, map, begin, end));
        }
        return res;
    }

    private List<List<String>> flatten(String[] sp, HashMap<String, List<String>>map, String begin, String end) {
        List<List<String>> h1 = flattenHalf(sp[0], map);
        List<List<String>> h2 = flattenHalf(sp[1], map);
        if (h1.get(0).get(h1.get(0).size()-1).equals(end)) {
            List<List<String>> temp = h1;
            h1 = h2;
            h2 = temp;
        }

        h1 = reverseAll(h1);
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> l1 : h1) {
            for (List<String> l2 : h2){
                List<String> l = new ArrayList<String>();
                l.addAll(l1);
                l.addAll(l2);
                res.add(l);
            }
        }
        return res;
    }

    private List<List<String>> flattenHalf(String w, HashMap<String, List<String>> map) {
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> running = new ArrayList<String>();
        fhelper(res, running, w, map);
        return res;
    }

    private void fhelper(List<List<String>> res, ArrayList<String> running, String w, HashMap<String, List<String>> map){
        running.add(w);
        if (!map.containsKey(w)) {
            res.add((List<String>)running.clone());
            return;
        }
        for(String prev : map.get(w)){
            fhelper(res, running, prev, map);
            running.remove(running.size()-1);
        }
    }

    private List<List<String>> reverseAll(List<List<String>> ll) {
        for(List<String> l : ll) {
            for (int i=0, j=l.size()-1; i<j; i++, j--){
                String temp = l.get(i);
                l.set(i, l.get(j));
                l.set(j, temp);
            }
        }
        return ll;
    }

}
