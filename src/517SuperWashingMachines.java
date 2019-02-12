// rare, see less
// better to understand:
// one caveat: one machine can take 2 at the same time but not give 2 at the same time from/to both left and right: only give to one way
// OJ says [3, 0, 3] requires 1 step only, meaning 0 in the middle can take 2 from left and right at the same time.
// https://discuss.leetcode.com/topic/80059/easy-understand-solution-o-n-time-and-o-1-space/2
class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i : machines) total += i;
        if(total % machines.length != 0) return -1;

        int avg = total / machines.length;
        int toleft = 0, toright = 0, res = 0;

        for(int load : machines) {
            toright = load - avg - toleft;
            int max = Math.max(toleft + toright, Math.max(Math.abs(toleft), Math.abs(toright))); //abs? // can simultaneously take but not give
            res = Math.max(res, max);
            toleft = -1 * toright;
        }

        return res;
    }
}

// concise
class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i : machines) total += i;
        if(total % machines.length != 0) return -1;

        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load - avg; //load-avg is single "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)),  load-avg); // cannot give two both left and right at the same time
        }

        return max;
    }
}

// greedy also works, always give from right, always use/record positive move value
// class Solution {
//     public int findMinMoves(int[] machines) {
//         int total = 0, target = 0, result = 0, n = machines.length;
//         for (int d : machines) total += d;
//         if (total == 0) return 0;
//         if (total % n != 0) return -1;
//         target = total / n;
//
//         int[] move = new int[n];
//         for (int i = 0; i < n - 1; i++) { // note < n-1
//             if (machines[i] > target) {
//                 move[i] += machines[i] - target; // note +=
//                 machines[i + 1] += machines[i] - target;
//                 machines[i] = target;
//                 result = Math.max(result, move[i]);
//             }
//             else {
//                 move[i + 1] = target - machines[i];
//                 machines[i + 1] -= target - machines[i];
//                 machines[i] = target;
//                 result = Math.max(result, move[i + 1]);
//             }
//         }
//
//         return result;
//     }
// }
