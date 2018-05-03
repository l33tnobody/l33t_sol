class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n : asteroids) {
            if(stack.isEmpty()) {
                stack.push(n);
                continue;
            }

            if(stack.peek() * n > 0 || stack.peek() < 0 && n > 0) {
                stack.push(n);
                continue;
            }
// an inference/observation is that if n is positive, always push to stack
            // moving towards each other, n is negative, stack top is positive
            while(!stack.isEmpty() && stack.peek() > 0 && -1 * n > stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() == -1 * n) { // both explode
                stack.pop();
                continue;
            }

            if(!stack.isEmpty() && stack.peek() > -1 * n) { // the current one explode
                continue;
            }

            // else stack is empty or the top is moving the same way
            stack.push(n);
        }

        int[] res = new int[stack.size()];
        for(int j=res.length - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }

        return res;
    }
}
