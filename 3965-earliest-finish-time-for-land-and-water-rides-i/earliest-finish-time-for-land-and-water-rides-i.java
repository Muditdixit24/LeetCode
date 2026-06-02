class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < m; j++) {

                
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                ans = Math.min(ans, waterStart + waterDuration[j]);

                
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                ans = Math.min(ans, landStart + landDuration[i]);
            }
        }

        return ans;
    }
}