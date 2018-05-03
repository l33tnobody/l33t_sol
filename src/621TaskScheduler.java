class Solution {
    public int leastInterval(char[] tasks, int n) { // an O(n) Math solution
        int[] counter = new int[26];
        int max=0;
        int maxCount=0;

        for(char t : tasks) {
            int c = ++counter[t-'A'];
            if(c == max) {
                maxCount++;
            } else if(c > max) {
                max = c;
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partLength * partCount;
        int availableTasks = tasks.length - max*maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}

// or reuse arrange String k distance apart
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int[] valid = new int[26]; // next valid index to guarantee k distance apart (or n+1 distance apart)
        for(int i=0; i<tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0, j=0; i<tasks.length; i++, j++) { // j is the current index in the result array, while i is the index for tasks
            int charpos = findValidMax(count, valid, j);
            if(charpos == -1) {
                sb.append("_");
                i--; // still looking at putting ith task
            } else {
                count[charpos]--;
                valid[charpos] = j+n+1; // update next valid index
                sb.append((char) (charpos + 'A'));
            }
        }

        return sb.length(); // return j
    }

    // find the max count char that is valid for putting into pos i
    private int findValidMax(int[] count, int[] valid, int i) {
        int max = 0;
        int charpos = -1;
        for(int j=0; j<count.length; j++) {
            if(count[j] > 0 && count[j] > max && i >= valid[j]) {
                charpos = j;
                max = count[j];
            }
        }
        return charpos;
    }
}
