class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i, dp));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int idx, int[] dp) {
        if (dp[idx] != 0) {
            return dp[idx];
        }

        int n = arr.length;
        int best = 1;

       
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (arr[i] >= arr[idx]) {
                break;
            }

            best = Math.max(best, 1 + dfs(arr, d, i, dp));
        }

        
        for (int i = idx + 1; i <= Math.min(n - 1, idx + d); i++) {
            if (arr[i] >= arr[idx]) {
                break;
            }

            best = Math.max(best, 1 + dfs(arr, d, i, dp));
        }

        dp[idx] = best;
        return best;
    }
}