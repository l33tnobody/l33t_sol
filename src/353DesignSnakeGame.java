class SnakeGame {
    // 2d encoded to 1d position using row*width + col
    Set<Integer> set; // fast look up for eating the body
    Deque<Integer> body; // updating head, tail and body
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        set = new HashSet<>();
        body = new LinkedList<>();
        set.add(0); // starts at 0, 0
        body.offerFirst(0);
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == -1) return -1;  // game already ended

        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch(direction) {
            case "U": rowHead--; break;
            case "D": rowHead++; break;
            case "L": colHead--; break;
            default:  colHead++; break;
        }

        int head = rowHead*width + colHead;

        set.remove(body.peekLast()); // new head can be where the tail was lastly, remove from the set first
        if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            score = -1;
            return score;
        }

        set.add(head);
        body.offerFirst(head);

        // check fruits
        if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast()); // add the previous tails back, the snake grows here
            foodIndex++;
            score++;
            return score;
        }

        // no increase in length;
        body.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
