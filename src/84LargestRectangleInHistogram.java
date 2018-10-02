// stack based: O(n) each bar get push and pop once
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>(); // stack of index
        int maxarea=0, i=0;
        // make a new array with 0 as ending
        int[] newA = new int[heights.length + 1];
        for(int j = 0; j < heights.length; j++) newA[j] = heights[j];
        newA[heights.length] = 0;
        
        while(i < newA.length) {
            if(st.isEmpty() || newA[st.peek()] <= newA[i]){ //if it is increasing bar
                st.push(i); // push index
                i++;
            } else {
                int t = st.pop();
                int candidate_area = newA[t]*(st.isEmpty()? i : i-st.peek()-1);
                maxarea = Math.max(maxarea, candidate_area);
            }
        }
        
        return maxarea;
    }
}
