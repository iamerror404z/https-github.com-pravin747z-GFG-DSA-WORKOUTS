class Solution {
    public boolean isSumOfConsecutive(int n) {
         
        // 1 cannot be represented
        if (n == 1) {
            return false;
        }

        // Check if n is power of 2
        if ((n & (n - 1)) == 0) {
            return false;
        }

        return true;
    }
}