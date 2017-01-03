/*
https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation
Since we are only interested in the longest valid substring,
our sliding windows need not shrink,
even if a window may cover an invalid substring.
We either grow the window by appending one char on the right,
or shift the whole window to the right by one.
And we only grow the window when the count of the new char exceeds the historical max count
(from a previous window that covers a valid substring length wise).

That is, we do not need the accurate max count of the current window; we only care if the max count exceeds the historical max count; and that can only happen because of the new char.

Here's my implementation that's a bit shorter

public int characterReplacement(String s, int k)
{
    int[] count = new int[128];
    int max=0;
    int start=0;
    for(int end=0; end<s.length(); end++)
    {
        max = Math.max(max, ++count[s.charAt(end)]);
        if(max+k<=end-start)
            count[s.charAt(start++)]--;
    }
    return s.length()-start;
}
*/

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, end = 0, maxrepeating = 0;

        for(; end<s.length(); end++) {
            maxrepeating = Math.max(maxrepeating, ++count[s.charAt(end) - 'A']);

            if( end-start+1-maxrepeating > k ){
                count[s.charAt(start) - 'A']--;
                start++; // the max substring len is now: end - start + 1;
            }
        }

        return s.length()-1 - start +1;
    }
}
