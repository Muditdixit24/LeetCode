import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[n + 1][m + 1];

       
        for (int i = 0; i < n; i++) {
            dp[i][m] = (long)1e18; 
        }

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i <= n; i++) {

                
                long res = dp[i][j + 1];

                long cost = 0;

                
                for (int k = 0; k < factory[j][1] && i + k <
                 n; k++) {
                    cost += Math.abs(robot.get(i + k) - 
                    factory[j][0]);
                    res = Math.min(res, cost + dp[i + k + 1]
                    [j + 1]);
                }

                dp[i][j] = res;
            }
        }

        return dp[0][0];
    }
}