class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum=0;
        int currentsum=0;
        int maxsum=nums[0];
        int currentminsum=0;
        int minsum=nums[0];
        for(int i=0;i<nums.length;i++){
            currentsum= Math.max(nums[i],currentsum+nums[i]);
            maxsum=Math.max(maxsum,currentsum);
            currentminsum= Math.min(nums[i],
                      currentminsum+nums[i]);
            minsum=Math.min(minsum,currentminsum);
            totalsum= totalsum+nums[i];
        }
        if(maxsum<0){
            return maxsum;
        }
        return  Math.max(maxsum,totalsum-minsum);
    }
}