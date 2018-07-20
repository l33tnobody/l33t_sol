class Solution {
    public String intToRoman(int num) {        
        final String RomanSequence="IVXLCDM";
        char[] RomanArray=RomanSequence.toCharArray();
        StringBuilder res= new StringBuilder();
        
        for(int base=0; num!=0; base+=2, num/=10) {
            int digit = num % 10;
            switch(digit) {
                case 1: case 2: case 3:
                    res.insert(0, multiString(RomanArray[base], digit));
                    break;
                case 4:
                    res.insert(0, RomanArray[base+1]);
                    res.insert(0, RomanArray[base]);
                    break;
                case 5:
                    res.insert(0, RomanArray[base+1]);
                    break;
                case 6: case 7: case 8:
                    res.insert(0, multiString(RomanArray[base], digit-5));
                    res.insert(0, RomanArray[base+1]);
                    break;
                case 9:
                    res.insert(0, RomanArray[base+2]);
                    res.insert(0, RomanArray[base]);
                    break;
                default:
                    break;
            }
        }
        return res.toString();
    }
    
    private String multiString(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for(int i = times; i > 0; i--) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
