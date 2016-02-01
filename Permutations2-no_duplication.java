import java.util.TreeSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return res;
        Integer[] newnum = new Integer[num.length];
        for(int i = 0; i < num.length; i++) newnum[i] = num[i];
        perm(newnum,0,res);
        return res;
    }

    private void perm(Integer[] num, int s, ArrayList<ArrayList<Integer>> res){
        if(s==num.length-1){  //last one, add result
            res.add(new ArrayList<Integer>(Arrays.asList(num)));
            return;
        }
        Set used=new TreeSet<Integer>();
        for(int i=s;i<num.length;i++){
            if(used.contains(num[i]))   continue;
            swap(num,s,i);
            perm(num,s+1,res);
            swap(num,s,i);
            used.add(num[i]);
        }
    }

    private void swap(Integer[]num, int i, int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}

