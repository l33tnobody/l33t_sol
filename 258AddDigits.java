public class Solution {
    public int addDigits(int num) {
        // return (num-1)%9 + 1; //https://en.wikipedia.org/wiki/Digital_root#Congruence_formula

        int temp = 0;
        while (true){
            temp += num%10;
            num /= 10;
            if(num == 0){
                if(temp <10)
                    break;
                else {
                    num=temp;
                    temp=0;
                }
            }
        }
        return temp;
    }
}
