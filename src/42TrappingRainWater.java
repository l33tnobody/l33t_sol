class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int mid = 0; // the peak in the middle
        for(int i=0; i<n; i++)    //get the peak of all
            if(height[i] > height[mid])
                mid = i;

        int h = 0;    //highest height to the left
        for(int i = 0; i < mid; i++){
            if(h > height[i])
                water += h - height[i];
            else h = height[i];
        }

        h = 0;    //highest height to the right
        for(int i=n-1; i>mid; i--){
            if(h > height[i])
                water += h - height[i];
            else
                h = height[i];
        }

        return water;
    }
}

// two pointers:
class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int water=0;
        int leftmax=0;
        int rightmax=0;

        while(l <= r) {
            leftmax = Math.max(leftmax, height[l]);
            rightmax = Math.max(rightmax, height[r]);
            if(leftmax < rightmax) {
                water += leftmax - height[l];
                l++;
            } else {
                water += rightmax - height[r];
                r--;
            }
        }
        return water;
    }
}
