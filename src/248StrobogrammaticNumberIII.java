// better recursion: DFS
public class Solution {

    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
		int[] count = {0}; // make it an object to pass around

		for(int n = low.length(); n <= high.length(); n++) {
		    char[] c = new char[n];
			helper(count, c, 0, n-1, low, high);
		}

        return count[0];
	}

	private void helper(int[] count, char[] running, int l, int r, String low, String high) {
        if (l>r) {
            String s = new String(running);
            if ( (s.length() == low.length() && s.compareTo(low) < 0) ||
                 (s.length() == high.length() && s.compareTo(high) > 0) )
                return;

            count[0]++;
            return;
        }

        for(char[] p : pairs) {
            if (l == 0 && l != r && p[0] == '0') continue;
            if (l == r && p[0] != p[1]) continue;

            running[l] = p[0];
            running[r] = p[1];
            helper(count, running, l + 1, r - 1, low, high);
        }
    }
}


// generate all the result and count
public class Solution {

    public int strobogrammaticInRange(String low, String high) {
		int count = 0;

		List<String> rst = new ArrayList<>();
		for(int n = low.length(); n <= high.length(); n++) {
			rst.addAll(helper(n, n));
		}

		for(String num : rst) {
			if( (num.length() == low.length() && num.compareTo(low) < 0 ) ||
			    (num.length() == high.length() && num.compareTo(high) > 0)) continue;

			count++;
		}

		return count;
	}

	private List<String> helper(int cur, int max) {
		if(cur == 0) return new ArrayList<String>(Arrays.asList(""));
		if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));

		List<String> rst = new ArrayList<>();
		List<String> prev = helper(cur - 2, max);

		for(String s : prev) {
			if(cur != max) rst.add("0" + s + "0");
			rst.add("1" + s + "1");
			rst.add("8" + s + "8");
			rst.add("6" + s + "9");
			rst.add("9" + s + "6");
		}

		return rst;
	}
}
