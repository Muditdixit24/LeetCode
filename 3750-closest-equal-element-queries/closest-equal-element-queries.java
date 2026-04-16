import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, n);

        Map<Integer, Integer> lastSeen = new HashMap<>();

        
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            int val = nums[idx];

            if (lastSeen.containsKey(val)) {
                int prevIndex = lastSeen.get(val) % n;
                int dist = i - lastSeen.get(val);

                minDist[idx] = Math.min(minDist[idx], dist);
                minDist[prevIndex] = Math.min(minDist[prevIndex], dist);
            }

            lastSeen.put(val, i);
        }

        
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            if (minDist[q] == n) result.add(-1);
            else result.add(minDist[q]);
        }

        return result;
    }
}