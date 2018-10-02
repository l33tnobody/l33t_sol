class Solution {
    public boolean isHappy(int n) {
        List<Integer> digits = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        while(!set.contains(n)) {
            set.add(n);
            digits.clear();
            while(n != 0) {
                int d = n%10;
                digits.add(d);
                n /= 10;
            }
            
            for(Integer i : digits) n += i*i;
            if(n == 1) return true;
        }
        
        return false;
    }
}