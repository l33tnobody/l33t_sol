// devide and conquer: detailed explanation:
// http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return recurSkyline(buildings, 0, buildings.length-1);
    }

    private LinkedList<int[]> recurSkyline(int[][] buildings, int p, int q) {
        if (p>q){
            return new LinkedList<int[]>();
        }
        if (p==q){
            LinkedList<int[]> res = new LinkedList<int[]>();
            res.add(new int[] {buildings[p][0], buildings[p][2]});
            res.add(new int[] {buildings[p][1], 0});
            return res;
        }
        else { // if (p<q){
            int mid=(p+q)/2;
            return merge(recurSkyline(buildings, p, mid),
                         recurSkyline(buildings, mid+1, q));
        }
    }

    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2){
        LinkedList<int[]> res = new LinkedList<int[]>();
        int h1=0, h2=0;
        while(l1.size()>0 && l2.size()>0){
            int x=0, h=0;
            if (l1.getFirst()[0]<l2.getFirst()[0]){
                x=l1.getFirst()[0];
                h1=l1.getFirst()[1];
                h=Math.max(h1,h2);
                l1.removeFirst();
            } else if (l1.getFirst()[0]>l2.getFirst()[0]){
                x=l2.getFirst()[0];
                h2=l2.getFirst()[1];
                h=Math.max(h1,h2);
                l2.removeFirst();
            } else { //x1==x2
                x=l1.getFirst()[0];
                h1=l1.getFirst()[1];
                h2=l2.getFirst()[1];
                h=Math.max(h1,h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if (res.size()==0 || res.getLast()[1]!=h){ //add only when height change
                res.add(new int[] {x,h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        return res;
    }
}

//priority queue, max heap:

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        for(int[] b : buildings) {
            height.add(new int[] {b[0], -b[2]}); // turn start to minus, so the sorting is correct
            height.add(new int[] {b[1], b[2]});
        }
        Collections.sort(height, (a,b) -> {
            if(a[0]!=b[0])
                return a[0]-b[0]; // the earlier the first to be processed
            else
                return a[1]-b[1]; // new building adding first, the taller the first;
                                  // as of removal, remove the shorter building first;
        });

        Queue<Integer> pq  = new PriorityQueue<>((a,b) -> (b-a)); //max heap, pass in a reverse comparator
        pq.offer(0);
        int prev=0;
        for(int[] h:height) {
            if(h[1]<0) { // start of a building
                pq.offer(-h[1]);
            } else { //end of a building
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev!=cur){
                result.add(new int[] {h[0], cur});
                prev=cur;
            }
        }

        return result;
    }
}
