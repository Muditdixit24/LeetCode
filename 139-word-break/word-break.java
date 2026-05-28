class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>(wordDict);
        boolean[]dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]){
                    String remaining=s.substring(j,i);
                    if(set.contains(remaining)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
        
    }
}