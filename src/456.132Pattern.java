// https://leetcode.com/problems/132-pattern/discuss/94077/Java-O(n)-solution-using-stack-in-detail-explanation
class Solution {
    class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n : nums) {
            if(stack.isEmpty() || n < stack.peek().min) {
                stack.push(new Pair(n,n));
                continue;
            }

            if(n > stack.peek().min) {
                Pair last = stack.pop();
                if(n < last.max) return true; // 132 pattern found
                else {
                    last.max = n;
                    while(!stack.isEmpty() && stack.peek().max <= n) stack.pop(); // stack top range covered by last, since last.min < top.min
                    // for now if stack is not empty then the top.max > n
                    if(!stack.isEmpty() && n > stack.peek().min) return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }
}
