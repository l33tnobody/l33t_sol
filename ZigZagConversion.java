public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows <= 1 || s==null || s=="") return s;

        StringBuilder[] list = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++) list[i] = new StringBuilder();
        int row=0;
        boolean down=true;
        for(int i=0; i< s.length(); i++){
            list[row].append(s.charAt(i));
            if(row==nRows-1) down=false;
            if(row==0) down=true;
            if(down) row++;
            else row--;

        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) res.append(sb.toString());

        return res.toString();
    }
}
