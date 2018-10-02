// https://discuss.leetcode.com/topic/40657/150-ms-45-lines-java-solution
// Another way to avoid duplicates is to use Set<List<Integer>> ret = new HashSet<>();
// and return new ArrayList<>(ret);
// time O(nk^2)
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);

        for (int i=0; i<words.length; i++) {
             for (int j=0; j <= words[i].length(); j++) {
                 String str1 = words[i].substring(0, j);
                 String str2 = words[i].substring(j);
                 if (isPalindrome(str1)) {
                     String str2rvs = new StringBuilder(str2).reverse().toString();
                     if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                         List<Integer> list = new ArrayList<Integer>();
                         list.add(map.get(str2rvs));
                         list.add(i);
                         ret.add(list);
                     }
                 }

                 if (isPalindrome(str2)) {
                     String str1rvs = new StringBuilder(str1).reverse().toString();
                     // str2.length() != 0 is for dedupping, think of ab and ba both exist in the list. 
                     // however if the completing string length is shorter, there is no such dup case, so only happens when on str2.length() == 0
                     if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) { 
                         List<Integer> list = new ArrayList<Integer>();
                         list.add(i);
                         list.add(map.get(str1rvs));
                         ret.add(list);
                     }
                 }
             }
        }

        return ret;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) !=  s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

//more optimized: reverse only once each word:
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(new StringBuilder(words[i]).reverse().toString(), i);

        for (int i=0; i<words.length; i++) {
             for (int j=0; j <= words[i].length(); j++) {
                 String str1 = words[i].substring(0, j);
                 String str2 = words[i].substring(j);
                 if (isPalindrome(str1)) {
                     if (map.containsKey(str2) && map.get(str2) != i) {
                         List<Integer> list = new ArrayList<Integer>();
                         list.add(map.get(str2));
                         list.add(i);
                         ret.add(list);
                     }
                 }

                 if (isPalindrome(str2)) {
                     if (map.containsKey(str1) && map.get(str1) != i && str2.length() != 0) {
                         List<Integer> list = new ArrayList<Integer>();
                         list.add(i);
                         list.add(map.get(str1));
                         ret.add(list);
                     }
                 }
             }
        }

        return ret;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) !=  s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
