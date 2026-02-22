class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxlength=0;
        int maxfreq=0;
        int[]freq=new int[26];
        while(right<n){
           char ch= s.charAt(right);
           freq[ch-'A']++;
           if(freq[ch-'A']>maxfreq){
            maxfreq=freq[ch-'A'];
           }
           int result= right-left+1;
           while(result-maxfreq>k){
            char leftchar= s.charAt(left);
            freq[leftchar-'A']--;
            left++;
            result= right-left+1;
           }
           maxlength= Math.max(maxlength,result);
           right++;
        }
        return maxlength;
    }
}