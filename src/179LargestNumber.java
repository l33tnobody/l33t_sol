public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length==0)
            return "";

        String[] strnums = new String[nums.length];
        for(int i=0; i<nums.length; i++)
            strnums[i] = nums[i] + "";

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                String ss1 = s1 + s2;
                String ss2 = s2 + s1;
                return ss1.compareTo(ss2);
            }
        };

        Arrays.sort(strnums, comp);
        if (strnums[strnums.length-1].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : strnums)
            sb.insert(0, s);

        return sb.toString();
    }
}
