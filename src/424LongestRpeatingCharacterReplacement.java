/*
https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation
We are only interested in the longest valid substring,
our sliding windows need not shrink, even if a window may cover an invalid substring.
We either grow the window by appending one char on the right,
or shift the whole window to the right by one.
And we only grow the window when the count of the new char exceeds the historical max count
(count only contains the chars within the current sliding window, so this means the maxrepeating char pointed by end pointer + 1 ,
and end + 1, the current subtring will be valid)
At the end the program, we get the length of this longest window size.
*/

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, end = 0, maxrepeating = 0;

        for(; end<s.length(); end++) {
            maxrepeating = Math.max(maxrepeating, ++count[s.charAt(end) - 'A']);

            if( end - start + 1 > maxrepeating + k ){
                count[s.charAt(start) - 'A']--;
                start++; // the max substring len is now: end - start + 1;
            }
        }

        return s.length() - 1 - start + 1;
    }
}
