// BFS:
// single-end search
public class Solution {
    // note: dictionary size can be huge ass with irrelevant words, so dont iterate on dictionary
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<String> tovisit = new ArrayList<String>();
        tovisit.add(beginWord);
        wordList.add(endWord);
        int dist=2;

        while(!tovisit.isEmpty()){
            ArrayList<String> newtovisit = new ArrayList<String>();
            for(String word : tovisit){
                char[] arr = word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    char orig = arr[i];
                    for(int j=0; j<26; j++){
                        arr[i] = (char)('a' + j);
                        String nei = String.valueOf(arr);

                        if (wordList.contains(nei)) {
                            if (nei.equals(endWord)) return dist;
                            newtovisit.add(nei);
                            wordList.remove(nei);
                        }
                    }
                    arr[i] = orig;
                }
            }

            tovisit = newtovisit;
            dist++;
        }
        return 0;
    }
}
// double end search:
public class Solution {
    // note: dictionary size can be huge ass with irrelevant words,
    // so dont iterate on dictionary to find neighbors, iterate on all possible neibor words instead

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();

        int dist = 2;
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // keep balance of begin and end set
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> neighbors = new HashSet<String>();
            for (String w : beginSet) {
                char[] arr = w.toCharArray();
                for (int i=0; i<arr.length; i++) {
                    char orig = arr[i];
                    for(char c='a'; c<='z';c++) {
                        arr[i] = c;
                        String target = String.valueOf(arr);
                        if (endSet.contains(target)) return dist;
                        if (!visited.contains(target) && wordList.contains(target)){
                            neighbors.add(target);
                            visited.add(target);
                        }
                    }
                    arr[i] = orig;
                }
            }

            beginSet = neighbors;
            dist++;
        }

        return 0;
    }
}

// keep track of visited words in dictionary: remove words when they are visited: fastest
public class Solution {
    // note: dictionary size can be huge ass with irrelevant words,
    // so dont iterate on dictionary to find neighbors, iterate on all possible neibor words instead

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        int dist = 2;
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // keep balance of begin and end set
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> neighbors = new HashSet<String>();
            for (String w : beginSet) {
                char[] arr = w.toCharArray();
                for (int i=0; i<arr.length; i++) {
                    char orig = arr[i];
                    for(char c='a'; c<='z';c++) {
                        arr[i] = c;
                        String target = String.valueOf(arr);
                        if (endSet.contains(target)) return dist;
                        if (wordList.contains(target)){
                            neighbors.add(target);
                            wordList.remove(target);
                        }
                    }
                    arr[i] = orig;
                }
            }

            beginSet = neighbors;
            dist++;
        }

        return 0;
    }
}
