public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null) return;
        int n=num.length;
        int i;
        for(i=n-1;i>0&&num[i]<=num[i-1];i--);
        if(i==0){reverse(num,0,n-1);return;}
        
        i--;//leftmost to be swapped.
        int j;
        for(j=n-1;num[j]<=num[i];j--);
        swap(num,i,j);
        reverse(num,i+1,n-1);
    }
    
    private void reverse(int[] num, int s, int e){
        while(s<e){
            swap(num, s, e);
            s++;
            e--;
        }
    }
    
    private void swap(int[] num, int i, int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
