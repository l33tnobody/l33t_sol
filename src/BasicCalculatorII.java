// w/o a stack
public class Solution {
    public int calculate(String s) {
        int len = s.length();
        int res=0;
        int preValue=0;
        char sign='+';
        int curValue=0;

        for(int i=0; i<len; i++){
            char c=s.charAt(i);

            if (Character.isDigit(c))
                curValue = curValue*10 + c - '0';

            if (!(Character.isDigit(c) || c==' ') || i==len-1){
                //new signs possible
                if (sign=='+'){
                    res+=preValue;
                    preValue=curValue;
                }
                else if (sign=='-'){
                    res+=preValue;
                    preValue=-curValue;
                }
                else if (sign=='*'){
                    preValue=preValue*curValue;
                }
                else if (sign=='/'){
                    preValue=preValue/curValue;
                }
                curValue=0;
                if (i!=len-1)
                    sign=c;
            }
        }
        res+=preValue;
        return res;
    }
}

// w/ stack easier to implement
public class Solution {
    public int calculate(String s) {
        int len=s.length();
        int res=0;
        int cur=0;
        char sign='+';
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<len; i++){
            char c=s.charAt(i);

            if (Character.isDigit(c))
                cur = cur*10 + c - '0';

            if(!(Character.isDigit(c) || c==' ') || i==len-1){
                if(sign=='-'){
                    st.push(-cur);
                }
                if(sign=='+'){
                    st.push(cur);
                }
                if(sign=='*'){
                    st.push(st.pop()*cur);
                }
                if(sign=='/'){
                    st.push(st.pop()/cur);
                }
                cur=0;
                sign=c;
            }
        }

        for(int e:st){
            res+=e;
        }

        return res;
    }
}
