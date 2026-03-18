class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid[0].length;
        int[] colSum = new int[n];
        int ans = 0;

        for (int[] row : grid) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += row[j];
                colSum[j] += sum;

                if (colSum[j] <= k) ans++;
                else break;
            }
        }
        return ans;
    }
}