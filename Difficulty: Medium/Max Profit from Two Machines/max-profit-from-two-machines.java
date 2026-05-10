import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;

        // Create a 2D array to store the profit difference and the original task index
        // diff[i][0] = Profit A - Profit B
        // diff[i][1] = Original Index
        int[][] diff = new int[n][2];

        for (int i = 0; i < n; i++) {
            diff[i][0] = a[i] - b[i]; // Calculate the relative advantage of Machine A
            diff[i][1] = i;           // Store the index to fetch the actual profit later
        }

        // Sort the array in descending order based on the difference.
        // Tasks where Machine A has the highest advantage over B will be at the front.
        Arrays.sort(diff, (u, v) -> v[0] - u[0]);

        int totalProfit = 0;

        // Iterate through the sorted tasks and greedily assign them
      totalProfit = 0;

        // Iterate through the sorted tasks and greedily assign them
        for (int i = 0; i < n; i++) {
            int idx = diff[i][1];
            int remainingTasks = n - i; // How many tasks are left to process

            // Assign to A if A has capacity AND (A pays better OR B doesn't have room for the rest)
            if (x > 0 && (a[idx] >= b[idx] || remainingTasks > y)) {
                totalProfit += a[idx];
                x--; // Decrease Machine A's remaining capacity
            } 
            // Otherwise, assign to B
            else {
                totalProfit += b[idx];
                y--; // Decrease Machine B's remaining capacity
            }
        }

        return totalProfit;
    }
}