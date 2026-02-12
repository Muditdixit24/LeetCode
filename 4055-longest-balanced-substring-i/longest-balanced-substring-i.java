class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                
                if (freq[idx] == 0) distinct++;
                freq[idx]++;
                
                // Compute min and max nonzero frequencies
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }
                
                // All nonzero frequencies equal -> balanced
                if (min == max) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
}