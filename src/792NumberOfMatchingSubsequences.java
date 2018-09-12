// optimal solution: move S once and move all possible words,
// time: S.length + Sum of all words length in words
// the reason to use Node with word and index to track current head is that
// substring() takes much longer time
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<Node>[] heads = new ArrayList[26];
        for(int i=0; i<heads.length; i++) {
            heads[i] = new ArrayList<Node>();
        }
        for(String w : words) heads[w.charAt(0) - 'a'].add(new Node(w, 0));
        
        int cnt = 0;
        for(char c : S.toCharArray()) {
            List<Node> l = heads[c - 'a'];
            int size = l.size();
            for(int i=0; i<size; i++) {
                Node n = l.remove(0);
                n.index++;
                if(n.index == n.word.length()) cnt++;
                else{
                    heads[n.word.charAt(n.index) - 'a'].add(n);
                }
            }
        }
        
        return cnt;
    }
    
    class Node { // tracking the current index of a word when moving the char by char according to S
        String word;
        int index;
        
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }
}

// naive solution will result in TLE:
// time: O(words.length*S.length + Sum of all length in words)
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i = 0;   // word index
            int j = 0;   // S index
            while (j < S.length() && i < w.length()) {
                if (S.charAt(j) == w.charAt(i)) {
                    j++;
                    i++;
                } else {
                    j++;
                }
            }
            if (i == w.length()) count++;
        }
        return count;
    }
}