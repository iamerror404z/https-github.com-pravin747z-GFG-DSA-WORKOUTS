class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        long sum = 0;          // S[r+1]
        long minPrefix = Long.MAX_VALUE;
        long prefixAtL = 0;    // S[l], advances as l grows
        long max = Long.MIN_VALUE;
        int l = 0;             // next index whose prefix sum needs adding

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            int lMax = r + 1 - k;
            while (l <= lMax) {
                minPrefix = Math.min(minPrefix, prefixAtL);
                prefixAtL += arr[l];
                l++;
            }

            if (r + 1 >= k) {
                max = Math.max(max, sum - minPrefix);
            }
        }

        return (int) max;
    }
}