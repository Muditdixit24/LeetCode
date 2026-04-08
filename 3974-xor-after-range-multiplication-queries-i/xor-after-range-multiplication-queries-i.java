class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], val = q[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((nums[i] * 1L * val) % MOD);
            }
        }

        int xor = 0;
        for (int x : nums) xor ^= x;

        return xor;
    }
}