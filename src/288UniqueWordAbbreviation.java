public class ValidWordAbbr {

    private Map<String, Set<String>> m; // a single hashset of all the words will do

    public ValidWordAbbr(String[] dictionary) {
        m = new HashMap<>();
        for(String w : dictionary) {
            String abrvs = abrv(w);
            Set<String> s = m.getOrDefault(abrvs, new HashSet<String>());
            s.add(w);
            m.put(abrvs, s);
        }
    }

    public boolean isUnique(String word) {
        String abrvs = abrv(word);

        if (!m.containsKey(abrvs)) return true;

        Set<String> s = m.get(abrvs);
        if (s.contains(word) && s.size() == 1) return true;

        return false; // s has no such word => different/other word in dict has same abbrv
                      // or s has such word in dict also, but other dict word has the same abbrv
    }

    private String abrv(String word) {
        if (word.length() <= 2) return word;
        int count = word.length() - 2;

        return "" + word.charAt(0) + count + word.charAt(word.length()-1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
