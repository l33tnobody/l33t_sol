class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int conL = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='A') countA++;
            if (countA>1) return false;
            if (c=='L') {
                conL++;
                if (conL > 2) return false;
            } else {
                conL=0;
            }
        }

        return true;
    }
}
