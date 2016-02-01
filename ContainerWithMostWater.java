public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        int j=height.length-1;
        int res=0;
        
        while(i<j){
            int m=height[i];
            int n=height[j];
            int tall=Math.min(m,n);   
            int tempArea=(j-i)*tall;
            if(tempArea>res) res=tempArea;
            
            if(tall==height[i]) i++;
            else j--;
        }
        
        return res;
    }
}
