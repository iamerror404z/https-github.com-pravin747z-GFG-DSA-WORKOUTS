class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long ans = 0;

        // Check bits from 0 to 30 (since arr[i] ≤ 10^5)
        for (int bit = 0; bit < 31; bit++) {
            long countSet = 0;

            // Count numbers with this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    countSet++;
                }
            }

            long countUnset = n - countSet;

            // Contribution of this bit
            ans += countSet * countUnset * (1L << bit);
        }

        return ans;
    }
}