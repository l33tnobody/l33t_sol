public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
// can cache here with a hashmap<String, List<Integer>>
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String left = input.substring(0, i);
                String right = input.substring(i+1);

                List<Integer> res_left = diffWaysToCompute(left);
                List<Integer> res_right = diffWaysToCompute(right);

                for(Integer l : res_left){
                    for(Integer r : res_right){
                        int temp = 0;
                        switch (c) {
                            case '+':
                                temp = l + r;
                                break;
                            case '-':
                                temp = l - r;
                                break;
                            case '*':
                                temp = l * r;
                                break;
                        }
                        res.add(temp);
                    }
                }
            }
        }

        if (res.size() == 0) { // a single number
            res.add(Integer.valueOf(input));
        }
// else set or always set (for parsing numbers too)
        return res;
    }
}
