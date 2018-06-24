class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>(); // store sum of parents length
        int maxlen = 0;
        
        for(String s : input.split("\n")) { // note \n and \t are length one char
            int level = getlevel(s); // count the number of leadinag \t, can use String.lastIndexOf()
            while(stack.size() > level) stack.pop(); // find right parent
            int len = (stack.isEmpty() ? 0 : stack.peek()) + s.length() - level + 1; // +1 for '/' 
            
            if(s.contains(".")) { // file
                maxlen = Math.max(maxlen, len - 1); // -1: there is no leading "/", and cannot accumulate -1 in the sums in the stack
                // do not need to push, since it will pop afterwards anyways
            } else stack.push(len); // push the dir length sum so far
        }
        
        return maxlen;
    }
    
    private int getlevel(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '\t') cnt++;
            else break;
        }
        return cnt;
    }
}