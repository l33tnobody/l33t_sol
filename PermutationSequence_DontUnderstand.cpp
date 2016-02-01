class Solution {
public:
    string getPermutation(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string str;
        vector<int> factorial(n + 1, 1);
        for (int i = 1; i <= n; ++i) {
            str += i + '0';
            factorial[i] = factorial[i-1] * i;
        }
        string perm;
        --k;    // convert to 0-based index
        for (int i = n - 1; i >= 0; --i) {
            int quotient = k / factorial[i];
            perm += str[quotient];
            str.erase(quotient, 1);
            k %= factorial[i];
        }
        return perm;
    }
};
