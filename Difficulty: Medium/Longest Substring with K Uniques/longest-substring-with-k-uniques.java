class Solution {
    public int longestKSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return -1;

        int[] freq = new int[26]; // since input is only lowercase letters
        int distinct = 0;
        int left = 0;
        int maxLen = -1;

        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';
            if (freq[r]++ == 0) distinct++;   // new distinct char enters the window

            // If we have more than k distinct, shrink from the left
            while (distinct > k) {
                int l = s.charAt(left) - 'a';
                if (--freq[l] == 0) distinct--; // one distinct char leaves the window
                left++;
            }

            // When we have exactly k distinct, update answer
            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}