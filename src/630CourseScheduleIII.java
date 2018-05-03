// Greedy

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b-a); // a max heap on course time
        int time = 0;

        for (int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1]) time -= pq.poll();
        }

        return pq.size();
    }
}
