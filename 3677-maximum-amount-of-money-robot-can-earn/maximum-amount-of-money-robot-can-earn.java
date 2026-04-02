class Solution {
    int[][] coins;
    Integer[][][] dp;
    int m, n;

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        m = coins.length;
        n = coins[0].length;
        dp = new Integer[m][n][3];
        return dfs(0, 0, 2);
    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n) return Integer.MIN_VALUE / 2;

        if (dp[i][j][k] != null) return dp[i][j][k];

        if (i == m - 1 && j == n - 1) {
            return k > 0 ? Math.max(0, coins[i][j]) : coins[i][j];
        }

        
        int ans = coins[i][j] + Math.max(
                dfs(i + 1, j, k),
                dfs(i, j + 1, k)
        );

        
        if (coins[i][j] < 0 && k > 0) {
            ans = Math.max(ans, Math.max(
                    dfs(i + 1, j, k - 1),
                    dfs(i, j + 1, k - 1)
            ));
        }

        return dp[i][j][k] = ans;
    }
}