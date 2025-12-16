
class Solution {
    public boolean areRotations(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        if (n == 0) return true; // both empty

        // Build LPS (Longest Prefix Suffix) for the pattern s2
        int[] lps = buildLps(s2);

        // KMP search: scan conceptual text = s1 + s1 without actually concatenating
        int i = 0; // index in pattern s2
        int j = 0; // index in conceptual text (0..2n-1)

        while (j < 2 * n) {
            char tj = (j < n) ? s1.charAt(j) : s1.charAt(j - n); // char from s1+s1

            if (tj == s2.charAt(i)) {
                i++;
                j++;
                if (i == n) {
                    // matched full pattern of length n
                    return true;
                }
            } else {
                if (i != 0) {
                    i = lps[i - 1]; // fallback within pattern using LPS
                } else {
                    j++; // no partial match, move forward in text
                }
            }
        }

        return false;
    }

    // Build LPS array for KMP
    private int[] buildLps(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // length of current longest prefix-suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // try shorter prefix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
