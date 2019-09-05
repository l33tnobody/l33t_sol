// insertion sort:

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() { // nlogn
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1]; // for same height sort based on indexes
                return b[0] - a[0]; // sort based on height descendingly
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tmp.add(people[i][1], people[i]); // n^2 since Arraylist insert shift is n for each insert
        } // linkedlist would require n for locating

        int res[][] = new int[n][2];

        for(int i=0; i<n; i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }
}
