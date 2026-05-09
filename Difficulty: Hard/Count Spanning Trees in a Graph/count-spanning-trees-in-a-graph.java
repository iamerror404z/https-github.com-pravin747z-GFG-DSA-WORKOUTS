class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n == 1) return 1;

        int[][] lap = new int[n][n];

        // Build Laplacian matrix
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }

        // Create (n-1)x(n-1) matrix
        double[][] mat = new double[n - 1][n - 1];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        return (int)Math.round(determinant(mat, n - 1));
    }

    // Gaussian elimination to compute determinant
    private double determinant(double[][] mat, int n) {
        double det = 1;

        for (int i = 0; i < n; i++) {
            int pivot = i;

            // Find non-zero pivot
            for (int j = i; j < n; j++) {
                if (Math.abs(mat[j][i]) > 1e-9) {
                    pivot = j;
                    break;
                }
            }

            if (Math.abs(mat[pivot][i]) < 1e-9) return 0;

            // Swap rows
            if (pivot != i) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }

            det *= mat[i][i];

            // Eliminate below
            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i] / mat[i][i];
                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }

        return det;
    }
}