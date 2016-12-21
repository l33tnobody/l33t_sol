public class WordDistance {

    private HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i=0; i < words.length; i++) {
            String w = words[i];
            if (map.containsKey(w)){
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(w, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int dist = Integer.MAX_VALUE;

        for(int i1=0, i2=0; i1<l1.size() && i2<l2.size(); ) {
            int i=l1.get(i1);
            int j=l2.get(i2);
            if (i>j) {
                dist=Math.min(dist, i-j);
                i2++;
            } else {
                dist=Math.min(dist, j-i);
                i1++;
            }
        }

        return dist;
    }
}
