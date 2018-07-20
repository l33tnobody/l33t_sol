class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] list = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) list[i] = new StringBuilder();
        int row=0;
        boolean down=true;
        for(int i=0; i< s.length(); i++) {
            list[row].append(s.charAt(i));
            if(row == numRows - 1) down = false;
            if(row == 0) down = true;
            if(down) row++;
            else row--;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) res.append(sb.toString());

        return res.toString();
    }
}