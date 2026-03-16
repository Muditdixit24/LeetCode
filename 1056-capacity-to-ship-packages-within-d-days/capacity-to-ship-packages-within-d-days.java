class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i=0;i<weights.length;i++){
            low= Math.max(low,weights[i]);
            high=high+weights[i];
        }
        while(low<high){
            int mid= (low+high)/2;
            int req=1;
            int currweight=0;
            for(int i=0;i<weights.length;i++){
                if(currweight+weights[i]>mid){
                    req++;
                    currweight=0;
                }
                currweight+=weights[i];
            }
            if(req<=days){
                high= mid;
            }
            else{
                low= mid+1;
            }
        }
        return low;
    }
}