// greedy: the best
class Solution {
    public String nextClosestTime(String time) {
        List<Character> nums = new ArrayList<>();
        char[] charr = time.toCharArray();
        for(int i=0; i<time.length(); i++) {
            if(time.charAt(i) != ':') nums.add(time.charAt(i));
        }
        Collections.sort(nums);
        
        for (int i = 0; i < 4; i++) {
            if (nums.get(i) > charr[4]) {
                charr[4] = nums.get(i);
                return new String(charr);
            }
        }
        charr[4] = nums.get(0); // assign smallest
        
        for (int i = 0; i < 4; i++) {
            if (nums.get(i) > charr[3] && nums.get(i) < '6') {
                charr[3] = nums.get(i);
                return new String(charr);
            }
        }
        charr[3] = nums.get(0);
        
        for (int i = 0; i < 4; i++) { // hour
            if (nums.get(i) > charr[1] && (charr[0] < '2' || nums.get(i) < '4')) {
                charr[1] = nums.get(i);
                return new String(charr);
            }
        }
        charr[1] = nums.get(0);
        
        for (int i = 0; i < 4; i++) {
            if (nums.get(i) > charr[0] && nums.get(i) <= '2') { // the charr[1] hour digit has to be <= 2 now, so no need to check if > 23 for hour
                charr[0] = nums.get(i);
                return new String(charr);
            }
        }
        charr[0] = nums.get(0);
        return new String(charr);
    }
}

// DFS all possibility also good: 4*4*4*4 = 256
class Solution {
    int diff = Integer.MAX_VALUE;
    String result = "";
    
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));
        
        if (set.size() == 1) return time;
        
        List<Integer> digits = new ArrayList<>(set);
        int minute = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));

        dfs(digits, "", 0, minute);

        return result;
    }

    private void dfs(List<Integer> digits, String cur, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (m == target) return; // there has to exist one closer time, since there are different digits
            int d = m - target > 0 ? m - target : 1440 + m - target; // other wise smaller time next day
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) continue;
            if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) continue;
            if (pos == 2 && digits.get(i) > 5) continue;
            // pos 3 has no restriction, 0-9 all good
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }
}