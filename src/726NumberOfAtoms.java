// using stack and hashmap
class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> res = new HashMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currmap = res;

        int i = 0;
        while(i < formula.length()) {
            if (Character.isUpperCase(formula.charAt(i))) {
                int j = readElement(formula, i, currmap);
                i = j;
            } else if (formula.charAt(i) == '(') {
                stack.push(currmap);
                currmap = new HashMap<String, Integer>();
                i++;
            } else if (formula.charAt(i) == ')') {
                int j = i+1;
                if (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    int multi = 1;
                    j = i+2;
                    while(j < formula.length() && Character.isDigit(formula.charAt(j))) j++;
                    multi = Integer.parseInt(formula.substring(i+1, j));
                    multiply(currmap, multi);
                }
                Map<String, Integer> uppermap = stack.pop();
                currmap = merge(uppermap, currmap);
                i = j;
            }
        }

        //output
        StringBuffer sb = new StringBuffer();
        List<String> elements = new ArrayList<>(res.keySet());
        Collections.sort(elements);
        for(String e : elements) {
            sb.append(e);
            int multi = res.get(e);
            if(multi != 1) sb.append(multi);
        }
        return sb.toString();
    }

    private int readElement(String s, int i, Map<String, Integer> m) {
        int j = i+1;
        while(j < s.length() && Character.isLowerCase(s.charAt(j))) j++;
        String element = s.substring(i, j);
        int multi = 1;
        if(j < s.length() && Character.isDigit(s.charAt(j))) {
            int k = j;
            j++;
            while(j<s.length() && Character.isDigit(s.charAt(j))) j++;
            multi = Integer.parseInt(s.substring(k, j));
        }
        m.put(element, m.getOrDefault(element, 0) + multi);
        return j;
    }

    private Map<String, Integer> merge(Map<String, Integer> m1, Map<String, Integer> m2) {
        for(Map.Entry<String, Integer> entry : m2.entrySet()) {
            m1.put(entry.getKey(), m1.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        return m1;
    }

    private void multiply(Map<String, Integer> map, Integer multi) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() * multi);
        }
    }
}
