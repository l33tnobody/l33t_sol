// recursive:
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] mem = new int[target+1];
        Arrays.fill(mem, -1);
        mem[0] = 1;

        return helper(nums, target, mem);
    }

    private int helper(int[] nums, int t, int[] mem) {
        if (mem[t] != -1) return mem[t];

        int res = 0;
        for(int i : nums) {
            if (t >= i) res += helper(nums, t-i, mem);
        }
        mem[t] = res;
        return res;
    }
}

// iterative:
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] mem = new int[target+1];
        mem[0] = 1;

        for(int i=1; i<=target; i++) {
            int res = 0;
            for(int n : nums) {
                if (i >= n) res += mem[i - n];
            }
            mem[i] = res;
        }

        return mem[target];
    }
}

// with sort:
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] mem = new int[target+1];
        Arrays.fill(mem, -1);
        mem[0] = 1;

        Arrays.sort(nums);

        return helper(nums, target, mem);
    }

    private int helper(int[] nums, int t, int[] mem) {
        if (mem[t] != -1) return mem[t];

        int res = 0;
        for(int i : nums) {
            if (i>t) break;
            res += helper(nums, t-i, mem);
        }
        mem[t] = res;
        return res;
    }
}

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] mem = new int[target+1];
        mem[0] = 1;

        Arrays.sort(nums);

        for(int i=1; i<=target; i++) {
            int res = 0;
            for(int n : nums) {
                if (i < n) break;
                res += mem[i - n];
            }
            mem[i] = res;
        }

        return mem[target];
    }
}
