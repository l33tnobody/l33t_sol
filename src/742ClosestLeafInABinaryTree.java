class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>(); // adjacency list
        // BFS build the undirected graph
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = null;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!graph.containsKey(node)) graph.put(node, new ArrayList<TreeNode>());
            if (node.left != null) {
                graph.get(node).add(node.left);
                graph.put(node.left, new ArrayList<>());
                graph.get(node.left).add(node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                graph.get(node).add(node.right);
                graph.put(node.right, new ArrayList<>());
                graph.get(node.right).add(node);
                queue.offer(node.right);
            }
            
            if (node.val == k) startNode = node;
        }
        
        //BFS to find the nearest leaf
        queue.offer(startNode);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null) return node.val;
            List<TreeNode> neighbors = graph.get(node);
            
            for (TreeNode tn : neighbors) {
                if(seen.contains(tn)) continue;
                
                if(tn.left == null && tn.right == null) return tn.val;
                seen.add(tn);
                queue.add(tn);
            }
        }
        
        return -1; // should never reach here
    }
}

// or use a parent map to record the parent for a node to complete the graph (tree contains connections to children already)
class Solution {
    TreeNode kNode = null;
    
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();   // store all edges that trace node back to its parent
        Queue<TreeNode> queue = new LinkedList<>();          // the queue used in BFS
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes
        
        // DFS: search for node whoes val == k
        DFS(root, k, backMap); // fill the graph, can use BFS here as well
        queue.add(kNode);
        visited.add(kNode);
        
        // BFS: find the shortest path
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) return curr.val;
            if(curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if(curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if(backMap.containsKey(curr) && visited.add(backMap.get(curr))) {  // go alone the back edge
                queue.add(backMap.get(curr));
            }
        }
        return -1; // never hit
    }
    
    private void DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) kNode = root;
        
        if(root.left != null) {
            backMap.put(root.left, root);
            DFS(root.left, k, backMap);
        }
        if(root.right != null) {
            backMap.put(root.right, root);
            DFS(root.right, k, backMap);
        }
    }        
}