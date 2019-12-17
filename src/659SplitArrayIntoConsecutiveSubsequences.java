// We iterate through the array once to get the frequency of all the elements in the array
// We iterate through the array once more and for each element,
//     we either see if it can be appended to a previously constructed consecutive sequence (higher priority)
//     or if it can be the start of a new consecutive sequence.
//     If neither are true, then we return false.
// note the array is sorted ascendingly (has to be sorted ascendingly, because we only expand to right side increasingly for all the consecutive sequences)
//      and the constructed sequence must be 3 to begin with, to ensure they are legitimate and does not require to be checked again for length.
// Time O(n)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i,0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue; // already used

            if (appendfreq.getOrDefault(i,0) > 0) { // try appending to existing 3 or more consecutive sequence first, greedy! the longer it can get appended the better
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1, 0) + 1);
            } else if (freq.getOrDefault(i+1, 0) > 0 && freq.getOrDefault(i+2, 0) > 0) { // started a new sequence of 3
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3, 0) + 1);
            } else { return false; }

            freq.put(i, freq.get(i) - 1); // either appended or started a new 3 sequence.
        }

        return true;
    }
}
