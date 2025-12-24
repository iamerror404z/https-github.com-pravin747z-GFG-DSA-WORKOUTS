class Solution {

    // 1️⃣ Find index of minimum element (pivot)
    public int minimum(int[] arr) {
        int start = 0, end = arr.length - 1;

        if (arr[start] <= arr[end]) {
            return start;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // 2️⃣ Floor search (largest value ≤ target) in sorted subarray
    public int floorBinarySearch(int[] arr, int start, int end, int target) {
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // 3️⃣ Count elements ≤ x
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int minIndex = minimum(arr);

        // Case 1: array not rotated
        if (minIndex == 0) {
            int pos = floorBinarySearch(arr, 0, n - 1, x);
            return pos == -1 ? 0 : pos + 1;
        }

        // Case 2: rotated array
        int left = floorBinarySearch(arr, minIndex, n - 1, x);
        int right = floorBinarySearch(arr, 0, minIndex - 1, x);

        int count = 0;

        if (left != -1) {
            count += left - minIndex + 1;
        }
        if (right != -1) {
            count += right + 1;
        }

        return count;
    }
}
