/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()) {
            Employee e = queue.poll();
            total += e.importance;
            for(int i : e.subordinates) {
                queue.offer(map.get(i));
            }
        }

        return total;
    }
}
