class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int i=0;i<nums.length;i++){
            high=Math.max(high,nums[i]);
        }
        while(low<high){
            int mid= low+(high-low)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum=sum+(nums[i]+mid-1)/mid;
            }
            if(sum<=threshold){
                high= mid;
            }
            else{
                low= mid+1;
            }
        }
        return low;
    }
}