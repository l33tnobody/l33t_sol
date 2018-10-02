// see also http://www.geeksforgeeks.org/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed/
// which is using a "counting sort"
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)  return 0;
        int m=matrix.length;
        int n=matrix[0].length;

        int maxarea=0;
        int[] height=new int[n];    //default to 0

        for(int i=0; i<m; i++){ // m * n time complexity
            for(int j=0; j<n; j++){
                height[j] = ((matrix[i][j]=='1')? height[j]+1 : 0);
            }

            maxarea=Math.max(maxarea, calcMaxArea(height));
        }

        return maxarea;
    }

    private int calcMaxArea(int[] A){
        Stack<Integer> st = new Stack<Integer>();
        int maxarea=0, i=0;
        int[] newA = new int[A.length + 1];
        for(int j=0; j<A.length; j++){newA[j]=A[j];}
        newA[A.length]=0;

        while(i<newA.length){
            if(st.isEmpty() || newA[st.peek()]<=newA[i])
                st.push(i++);
            else{
                int t=st.pop();
                maxarea=Math.max(maxarea, newA[t] * (st.isEmpty()? i : i-st.peek()-1) );
            }
        }

        return maxarea;
    }
}
