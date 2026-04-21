class Solution {
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n) || d % gcd(m, n) != 0) return -1;

        // Return the minimum steps between the two possible pouring directions
        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    private int solve(int fromCap, int toCap, int target) {
        int from = fromCap; // Initial fill
        int to = 0;
        int steps = 1; // First step: fill 'from' jug

        while (from != target && to != target) {
            // Find max amount that can be poured
            int pourAmount = Math.min(from, toCap - to);

            // Pour
            to += pourAmount;
            from -= pourAmount;
            steps++;

            if (from == target || to == target) break;

            // If 'to' jug is full, empty it
            if (to == toCap) {
                to = 0;
                steps++;
            }

            // If 'from' jug is empty, fill it
            if (from == 0) {
                from = fromCap;
                steps++;
            }
        }
        return steps;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}