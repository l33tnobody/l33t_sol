class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26]; //will contain number of occurences of character, to see if a char is the last one
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = s.toCharArray();
        for(char c: ch) res[c-'a']++;

        Stack<Character> st = new Stack<>();
        for(char c : ch) {
            int index = c - 'a';
            res[index]--; // processed one anyways
            if(visited[index]) continue; //dedup

            //if current character is smaller than last character in stack which also occurs later in the string again
        //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!st.isEmpty() && c < st.peek() && res[st.peek() - 'a'] != 0) {
                char top = st.pop();
                visited[top - 'a'] = false;
            }
            st.push(c); //add current character and mark it as visited
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
