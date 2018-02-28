class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if(x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();

        while(stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();

        while(!temp.isEmpty()) pushHelper(temp.pop());

        return max;
    }
}


// or use a heap: priority queue: just for reference

Stack<Integer> s;
PriorityQueue<Integer> pq;
/** initialize your data structure here. */
public MaxStack() {
    s = new Stack<Integer>();
    pq = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
}

public void push(int x) {
    s.push(x);
    pq.offer(x);
}

public int pop() {
    int pop = s.pop();
    pq.remove(pop);
    return pop;
}

public int top() {
    return s.peek();
}

public int peekMax() {
    return pq.peek();
}

public int popMax() {
    int max = pq.poll();
    Stack<Integer> sp = new Stack<Integer>();
    while (!s.isEmpty()) {
        if (s.peek() != max) {
            sp.push(s.pop());
        } else {
            s.pop();
            break;
        }
    }
    while (!sp.isEmpty()) {
        s.push(sp.pop());
    }
    return max;
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
