class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<int> st;
        int i = 0, maxarea = 0;
        height.push_back(0);
        while(i < height.size()) {
            if(st.empty() || height[st.top()] <= height[i])
                st.push(i++);
            else {
                int t = st.top();
                st.pop();
                maxarea = max(maxarea, height[t] * (st.empty() ? i : i - st.top() - 1 ));
            }
        }
        return maxarea;
    }
};

// Java
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int maxarea=0, i=0;
        // make a new array with 0 as ending
        int[] newA=new int[height.length+1];
        for(int j=0; j<height.length; j++){newA[j]=height[j];}
        newA[height.length]=0;

        while(i<newA.length){
            if(st.isEmpty() || newA[st.peek()]<=newA[i]){ //if it is increasing bars
                st.push(i);
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
