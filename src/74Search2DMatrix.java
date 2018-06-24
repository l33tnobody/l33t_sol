public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        if(rows == 0) return false;
        int cols=matrix[0].length;
        if(cols == 0) return false;

        int l=0, r=rows*cols-1;
        while(l<=r){
            int mid=(l+r)/2;
            int vmid=matrix[mid/cols][mid%cols];
            if(vmid==target) return true;
            if(vmid<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
}
