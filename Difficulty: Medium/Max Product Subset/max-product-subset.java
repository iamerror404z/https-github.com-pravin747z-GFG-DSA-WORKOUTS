class Solution {
    public int findMaxProduct(int[] arr) {
        if (arr.length == 1) return arr[0];
        final int mod = (int)Math.pow(10, 9) + 7;
        
        long[] posProduct = new long[2]; // [0]=product, [1]=count
        long[] negProduct = new long[3]; // [0]=product, [1]=count, [2]=maxNeg
        
        negProduct[2] = Long.MIN_VALUE;
        int zeroCount = 0;
        
        // PASS 1: Your logic to gather the stats
        for (int curr : arr) {
            if (curr == 0) {
                zeroCount++;
            } else if (curr < 0) {
                negProduct[2] = Math.max(negProduct[2], (long)curr);
                negProduct[1]++;
            } else {
                posProduct[1]++;
            }
        }
        
        // Edge Case Handling: If array is all zeros, or only 1 negative and rest zeros
        if (zeroCount == arr.length || (negProduct[1] == 1 && posProduct[1] == 0 && zeroCount > 0)) {
            return 0;
        }
        
        long maxProduct = 1;
        boolean maxNegSkipped = false;
        
        // PASS 2: Apply your multiplication safely with modulo
        for (int curr : arr) {
            if (curr == 0) continue;
            
            // Your logic: If odd negatives, skip ONE instance of the largest negative
            if (curr < 0 && negProduct[1] % 2 != 0 && curr == negProduct[2] && !maxNegSkipped) {
                maxNegSkipped = true;
                continue;
            }
            
            // Safe modulo multiplication at EVERY step
            maxProduct = (maxProduct * curr) % mod;
        }
        
        // In Java, modulo on a negative number returns negative. 
        // We force it positive just in case.
        if (maxProduct < 0) {
            maxProduct = (maxProduct + mod) % mod;
        }
        
        return (int) maxProduct;
    }
}