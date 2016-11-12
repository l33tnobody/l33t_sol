// an O(n) solution rather than going through every start i O(n^2)
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0, tank=0, total=0;
        for(int i=0; i<gas.length; i++) {
            if ((tank=tank+gas[i]-cost[i]) < 0) {
                start=i+1;
                total+=tank;
                tank=0;
            }
        }
        return (total+tank<0) ? -1 : start;
    }
}
