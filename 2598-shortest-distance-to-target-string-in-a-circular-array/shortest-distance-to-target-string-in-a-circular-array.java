class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n; 

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int d = Math.abs(i - startIndex);
                ans = Math.min(ans, Math.min(d, n - d));
            }
        }

        return ans == n ? -1 : ans;
    }
}