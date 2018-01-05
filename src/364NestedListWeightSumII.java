// other approaches: might be not as good:
//   DFS get the depth first and decrease and multiply
//   put sum of each level into an arraylist or hashmap, inverse the index and multiply

// adding using weighted and unweighted
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;

        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) unweighted += ni.getInteger();
                else nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }

        return weighted;
    }
}
