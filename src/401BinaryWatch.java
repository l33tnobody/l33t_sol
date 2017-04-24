public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] digits = new int[10];
        // Arrays.fill(digits, 0);

        helper(res, digits, num, 0);
        return res;
    }

    private void helper(List<String> res, int[] digits, int num, int start) {
        if (num == 0) {
            String time = convert(digits);
            if (time.length() != 0) res.add(time); // check valid time
            return;
        }

        for(int i=start; i <= digits.length - num; i++) {
            digits[i] = 1;
            helper(res, digits, num-1, i+1);
            digits[i] = 0;
        }

    }

    private String convert(int[] digits) {
        int h = 0;
        if (digits[0] == 1) h += 8;
        if (digits[1] == 1) h += 4;
        if (digits[2] == 1) h += 2;
        if (digits[3] == 1) h += 1;
        if (h>=12) return ""; // check valid time

        int m = 0;
        if (digits[4] == 1) m += 32;
        if (digits[5] == 1) m += 16;
        if (digits[6] == 1) m += 8;
        if (digits[7] == 1) m += 4;
        if (digits[8] == 1) m += 2;
        if (digits[9] == 1) m += 1;
        if (m>=60) return ""; // check valid time

        // return String.format("%d:%02d", h, m);
        return String.valueOf(h) + ":" + (m < 10 ? "0" : "" ) + String.valueOf(m);
    }
}

// cheating:
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++) {
            for (int m=0; m<60; m++) {
                if (Integer.bitCount((h << 6) + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}
