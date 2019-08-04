/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Recursive DFS
public class Solution {
    // from label to the cloned node
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode n) {
        if (n==null) return null;

        if (map.containsKey(n.label)) return map.get(n.label);

        UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
        map.put(n.label, copy);

        for(UndirectedGraphNode neighbor : n.neighbors) {
            copy.neighbors.add(clone(neighbor));
        }
        return copy;
    }
}

// Iterative BFS solution:
public class Solution {
    // from label to the cloned node
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return node;

        // the queue is used to add neighbors to the copied nodes from the origin nodes
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        LinkedList<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.pop(); // the first element in the queue
            UndirectedGraphNode ncopy = map.get(n.label);
            for(UndirectedGraphNode neighbor : n.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
                ncopy.neighbors.add(map.get(neighbor.label));
            }
        }

        return newNode;
    }

}
