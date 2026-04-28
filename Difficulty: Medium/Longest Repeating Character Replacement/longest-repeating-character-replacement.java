class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] counts = new int[26]; // To store frequency of 'A'-'Z'
        
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int right = 0; right < n; right++) {
            // Update the frequency of the current character
            counts[s.charAt(right) - 'A']++;
            
            // Keep track of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, counts[s.charAt(right) - 'A']);
            
            // If the number of characters to replace exceeds k, shrink the window
            // Formula: (window width) - maxFreq > k
            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't strictly need to update maxFreq here. 
                // The result only improves if we find a NEW higher maxFreq.
            }
            
            // Update the global maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}