class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        for (String op : ops) {
            int score = 0;
            int n = list.size();

            if(op.equals("+")) {
                score = list.get(n-1) + list.get(n-2);
                list.add(score);
                sum += score;
            } else if(op.equals("D")) {
                score = list.get(n-1) * 2;
                list.add(score);
                sum += score;
            } else if(op.equals("C")) {
                score = list.remove(n-1);
                sum -= score;
            } else {
                score = Integer.parseInt(op);
                list.add(score);
                sum += score;
            }
        }

        return sum;
    }
}
