class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1;
        int high = position[n - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlaceCows(int[] position, int 
    m, int dist) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                count++;
                last = position[i];
            }

            if (count >= m) return true;
        }

        return false;
    }
}