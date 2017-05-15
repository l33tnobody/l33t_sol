public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> res = new LinkedList<>();

        for(String[] t : tickets){
            if(!adj.containsKey(t[0])) adj.put(t[0], new PriorityQueue<>());
            adj.get(t[0]).add(t[1]);
        }

        dfs(adj, res, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, List<String> res, String from) {
        PriorityQueue<String> q = adj.get(from);
        while(q != null && !q.isEmpty()) { // equivalent to if
            dfs(adj, res, q.poll());
        }
        res.add(0, from);
    }
}

// iterative not very straightforward
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> res = new LinkedList<>();

        for(String[] t : tickets){
            if(!adj.containsKey(t[0])) adj.put(t[0], new PriorityQueue<>());
            adj.get(t[0]).add(t[1]);
        }

        Stack<String> st = new Stack<>();
        st.push("JFK");
        while(!st.isEmpty()) {
            while(adj.get(st.peek()) != null && !adj.get(st.peek()).isEmpty()) {
                st.push(adj.get(st.peek()).poll());
            }
            res.add(0, st.pop());
        }

        return res;
    }
}
