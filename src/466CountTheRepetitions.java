// a brute force way:
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;

        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                if (j == array2.length) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == array1.length) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }
}

// dont quite understand the table:
// https://discuss.leetcode.com/topic/70667/c-0ms-o-str1-length-str2-length
// https://discuss.leetcode.com/topic/70887/very-clean-and-short-7ms-java-solution-based-on-70664914-s-idea
