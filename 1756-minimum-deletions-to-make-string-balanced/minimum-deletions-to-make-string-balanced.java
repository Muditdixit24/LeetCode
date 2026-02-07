class Solution {
    public int minimumDeletions(String s) {
        int countb=0;
        int delete=0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='b') countb++;
            else{
                delete= Math.min(delete+1,countb);
            }
        }
        return delete;
    }
}