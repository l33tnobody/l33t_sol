// array
class MovingAverage {
    private int[] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        n = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length) n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }
}

// linkedlist
class MovingAverage {
    private double sum;
    private int size;
    private List<Integer> window;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        sum = 0.0;
        window = new LinkedList<>();
    }

    public double next(int val) {
        if(window.size() == size) {
            sum -= window.remove(0);
        }
        window.add(val);
        sum += val;
        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
