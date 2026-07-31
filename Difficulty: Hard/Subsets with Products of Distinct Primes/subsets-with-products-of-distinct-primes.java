

class Solution {
    static final int MOD = 1000000007;
    static int[] primeMask = new int[31];
    static long[][] memo;
    static int[] freq;

    // step 1: build prime factor masks for 1..30
    static void buildPrime() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int num = 1; num <= 30; num++) {
            int n = num, mask = 0;
            for (int i = 0; i < primes.length; i++) {
                int p = primes[i], cnt = 0;
                while (n % p == 0) { cnt++; n /= p; }
                if (cnt > 1) { mask = -1; break; }
                if (cnt == 1) mask |= (1 << i);
            }
            primeMask[num] = mask;
        }
    }

    // recursion: idx goes 2..30, mask = used primes so far
    static long solve(int idx, int mask) {
        if (idx > 30) return 1; // base case: one way to stop (empty continuation)

        if (memo[idx][mask] != -1) return memo[idx][mask];

        // option 1: skip current number
        long res = solve(idx + 1, mask);

        // option 2: take current number (if valid and no conflict)
        if (freq[idx] != 0 && (mask & primeMask[idx]) == 0) {
            res = (res + solve(idx + 1, mask | primeMask[idx]) * freq[idx]) % MOD;
        }

        return memo[idx][mask] = res;
    }

    static long countSubsets(int[] arr) {
        buildPrime();

        // step 2: freq map
        freq = new int[31];
        for (int x : arr) freq[x]++;

        // step 3: mark invalid numbers (repeated prime) as 0
        for (int num = 2; num <= 30; num++) {
            if (primeMask[num] == -1) freq[num] = 0;
        }

        int ones = freq[1];

        // step 4: recursion + memo over numbers 2..30, starting mask = 0
        memo = new long[31][1024];
        for (long[] row : memo) Arrays.fill(row, -1);

        long total = solve(2, 0); // includes empty subset (mask=0 path)
        long ans = (total - 1 + MOD) % MOD; // remove empty subset

        long pow2 = 1;
        for (int i = 0; i < ones; i++) pow2 = (pow2 * 2) % MOD;
        ans = (ans * pow2) % MOD;

        return ans;
    }
  // 
}