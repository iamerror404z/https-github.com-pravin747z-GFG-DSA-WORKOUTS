class Solution {
    public int maxArea(List<Integer> height) {
         int res = 0;
        int n = height.size();

        int i = 0, j = n - 1;

        while (i < j) {

            int width = j - i - 1;

            if (height.get(i) < height.get(j)) {
                res = Math.max(res, width * height.get(i));
                i++;
            }
            else if (height.get(j) < height.get(i)) {
                res = Math.max(res, width * height.get(j));
                j--;
            }
            else {
                res = Math.max(res, width * height.get(i));
                i++;
                j--;
            }
        }

        return res;
        
    }
}