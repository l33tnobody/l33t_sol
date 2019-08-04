// room itself is the adjacency list
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> rooms, boolean[] visited) {
        visited[node] = true;

        for (int n : rooms.get(node)) {
            if (visited[n])
                continue;
            dfs(n, rooms, visited);
        }
    }
}

// using a set as visited:
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);

        return visited.size() == rooms.size();
    }

    private void dfs(int node, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(node);

        for(int n : rooms.get(node)) {
            if(visited.contains(n)) continue;
            dfs(n, rooms, visited);
        }
    }
}

