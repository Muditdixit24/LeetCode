import java.util.*;

class Solution {
    private Integer[][] memo;
    private int[][] robotPairs;
    private int[] sortedWalls;
    private int n;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        this.n = robots.length;
        this.robotPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            robotPairs[i][0] = robots[i];
            robotPairs[i][1] = distance[i];
        }

       
        Arrays.sort(robotPairs, (a, b) -> Integer.compare(a
        [0], b[0]));
        
        Arrays.sort(walls);
        this.sortedWalls = walls;
        
        
        this.memo = new Integer[n][2];

        return dfs(n - 1, 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) return 0;
        if (memo[i][j] != null) return memo[i][j];

       
        int leftLimit = robotPairs[i][0] - robotPairs[i][1];
        
        if (i > 0) {
            leftLimit = Math.max(leftLimit, robotPairs[i - 1]
            [0] + 1);
        }
        int leftWallCount = countWallsInRange(leftLimit, 
        robotPairs[i][0]);
        int result = dfs(i - 1, 0) + leftWallCount;

        
        int rightLimit = robotPairs[i][0] + robotPairs[i][1];
        if (i + 1 < n) {
            
            if (j == 0) {
                
                 
                rightLimit = Math.min(rightLimit, robotPairs
                [i + 1][0] - robotPairs[i + 1][1] - 1);
            } else {
                rightLimit = Math.min(rightLimit, robotPairs
                [i + 1][0] - 1);
            }
        }
        int rightWallCount = countWallsInRange(robotPairs[i]
        [0], rightLimit);
        
        
        result = Math.max(result, dfs(i - 1, 1) + 
        rightWallCount);

        return memo[i][j] = result;
    }

    private int countWallsInRange(int start, int end) {
        if (start > end) return 0;
        int leftIdx = lowerBound(sortedWalls, start);
        int rightIdx = lowerBound(sortedWalls, end + 1);
        return rightIdx - leftIdx;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}