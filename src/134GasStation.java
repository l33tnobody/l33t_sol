// an O(n) solution rather than going through every start i O(n^2)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int cur_tank = 0;
        int starting_station = 0;

        for (int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            cur_tank += gas[i] - cost[i];

            if (cur_tank < 0) {
                starting_station = i + 1;
                cur_tank = 0;
            }
        }

        return total_tank < 0 ? -1 : starting_station;
    }
}
