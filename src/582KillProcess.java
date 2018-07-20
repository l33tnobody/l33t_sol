class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) return pid; // not including 0 itself
        
        int n = pid.size();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(pid.get(i), new LinkedList<Integer>()); // directed graph adj list
        }
        for (int i = 0; i < n; i++) {
            if (tree.containsKey(ppid.get(i))) { // directed graph: from parent to child and skip 0
                List<Integer> children = tree.get(ppid.get(i));
                children.add(pid.get(i));
            }
        }
        
        List<Integer> result = new ArrayList<>();
        traverse(tree, result, kill);
        
        return result;
    }
    
    private void traverse(Map<Integer, List<Integer>> tree, List<Integer> result, int pid) {
        result.add(pid);
        
        List<Integer> children = tree.get(pid);
        for (Integer child : children) {
            traverse(tree, result, child);
        }
    }    
}