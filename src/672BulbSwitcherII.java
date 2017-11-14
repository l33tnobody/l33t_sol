// https://discuss.leetcode.com/topic/102033/java-o-1
// We only need to consider special cases which n<=2 and m < 3. When n >2 and m >=3, the result is 8.
// The four buttons:
//
// Flip all the lights.
// Flip lights with even numbers.
// Flip lights with odd numbers.
// Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
// If we use button 1 and 2, it equals to use button 3.
// Similarly...
//
// 1 + 2 --> 3, 1 + 3 --> 2, 2 + 3 --> 1
// So, there are only 8 cases.
//
// All_on, 1, 2, 3, 4, 1+4, 2+4, 3+4
//
// And we can get all the cases, when n>2 and m>=3.

class Solution {
    public int flipLights(int n, int m) {
        if(m==0 || n==0) return 1;
        if(n==2 && m==1) return 3;
        if(n==2) return 4; // && m >= 2
        if(m==1) return 4; // n >= 3 possible to have 8 states from now on
        if(m==2) return 7; // when n >= 3 and m==2 only step 4 state cannot reach
        return 8; // m >= 3 && n >= 3
    }
}
