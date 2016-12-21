public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1=-1, p2=-1, dist=Integer.MAX_VALUE;

        for(int i=0; i<words.length; i++) {
            boolean updated = false;

            if (words[i].equals(word1)) {
                p1=i;
                updated = true;
            }

            if (words[i].equals(word2)) {
                p2=i;
                updated = true;
            }

            if (updated && p1!=-1 && p2!=-1) dist=Math.min(dist, Math.abs(p1-p2));
        }

        return dist;
    }
}
