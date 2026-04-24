class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count =0;
        int count1=0;
        int count2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L') count++;
            else if(moves.charAt(i)=='R'){
                count1++;
            }
            else{
                count2++;
            }
        }
        int max=Math.abs(count1-count)+count2;
        return max;
    }
}