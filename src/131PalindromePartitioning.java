// DP n^2 + DFS (stack space n)

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        boolean[][] table = new boolean[len][len]; // DP table to tell if it is a string from l to r
                                                   // default to false
        for(int r=0; r<s.length(); r++) {
            for(int l=0; l<=r; l++) {
                if (s.charAt(l)==s.charAt(r) && (r-l<=2 || table[l+1][r-1]==true)) {
                    table[l][r] = true;
                }
            }
        }

        helper(res, new ArrayList<String>(), table, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] table, String s, int pos) {
        if(pos==s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=pos; i<s.length(); i++) {
            if(table[pos][i]) {
                path.add(s.substring(pos, i+1));
                helper(res, path, table, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

// Iterative DP solution, just for reference
public class Solution {
 	public static List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] pair = new boolean[len][len];

		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();

			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
					pair[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}
}
