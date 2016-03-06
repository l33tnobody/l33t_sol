public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        int bulls=0;
        int cows=0;

        for (int i=0; i<secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s==g) {
                bulls++;
            } else {
                nums1[s-'0']++;
                nums2[g-'0']++;
            }
        }

        for (int i=0; i<nums1.length; i++){
            cows+=Math.min(nums1[i], nums2[i]);
        }

        String res = bulls + "A" + cows + "B";
        return res;
    }
}

// one pass with one array, using positive and negative numbers to get cows
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
