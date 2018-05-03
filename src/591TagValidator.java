class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<code.length();) {
            if(i > 0 && stack.isEmpty()) return false; // check single outer-most wrapped tag

            if (code.startsWith("<![CDATA[", i)) {
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i<0) return false;
                i+=3;
            } else if (code.startsWith("</", i)) {
                int j = i+2;
                i = code.indexOf(">", j);
                if(i<0 || i==j || i-j > 9) return false;
                for(int k=j; k<i; k++) {
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String t = code.substring(j, i);
                if(stack.isEmpty() || !stack.pop().equals(t)) return false;
                i++;
            } else if(code.startsWith("<", i)) {
                int j = i+1;
                i = code.indexOf('>', j);
                if(i<0 || i==j || i-j > 9) return false;
                for(int k=j; k<i; k++) {
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String t = code.substring(j, i);
                stack.push(t);
                i++;
            } else {
                i++;
            }
        }

        return stack.isEmpty();

    }
}
