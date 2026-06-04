class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            ans += waviness(x);
        }

        return ans;
    }

    private int waviness(int x) {
        String s = String.valueOf(x);

        if (s.length() < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char prev = s.charAt(i - 1);
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);

            if ((cur > prev && cur > next) ||
                (cur < prev && cur < next)) {
                count++;
            }
        }

        return count;
    }
}