class Solution {
    private char[] s;
    private boolean[][][][] seen;
    private long[][][][] cntMemo, sumMemo;

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private long calc(long n) {
        if (n <= 0) return 0;
        s = Long.toString(n).toCharArray();
        int m = s.length;

        // pos, lenCat(0,1,2), prevPrev(0..10), prev(0..10)
        seen = new boolean[m][3][11][11];
        cntMemo = new long[m][3][11][11];
        sumMemo = new long[m][3][11][11];

        return dfs(0, 0, 10, 10, true)[1];
    }

    // returns {count of numbers, total waviness}
    private long[] dfs(int pos, int len, int prevPrev, int prev, boolean tight) {
        if (pos == s.length) return new long[]{1, 0};

        if (!tight && seen[pos][len][prevPrev][prev]) {
            return new long[]{cntMemo[pos][len][prevPrev][prev],
                              sumMemo[pos][len][prevPrev][prev]};
        }

        int limit = tight ? s[pos] - '0' : 9;
        long count = 0, sum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean ntight = tight && d == limit;

            if (len == 0 && d == 0) {
                long[] res = dfs(pos + 1, 0, 10, 10, ntight);
                count += res[0];
                sum += res[1];
            } else if (len == 0) {
                long[] res = dfs(pos + 1, 1, 10, d, ntight);
                count += res[0];
                sum += res[1];
            } else if (len == 1) {
                long[] res = dfs(pos + 1, 2, prev, d, ntight);
                count += res[0];
                sum += res[1];
            } else {
                int add = ((prev > prevPrev && prev > d) ||
                           (prev < prevPrev && prev < d)) ? 1 : 0;

                long[] res = dfs(pos + 1, 2, prev, d, ntight);
                count += res[0];
                sum += res[1] + add * res[0];
            }
        }

        if (!tight) {
            seen[pos][len][prevPrev][prev] = true;
            cntMemo[pos][len][prevPrev][prev] = count;
            sumMemo[pos][len][prevPrev][prev] = sum;
        }

        return new long[]{count, sum};
    }
}