class Solution {
    public int pivotIndex(int[] nums) {  
        int totol=0;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<nums.length;i++){
            totol=totol+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightsum = totol-leftsum-nums[i];

        
        if(leftsum==rightsum){
            return i;
        }
        leftsum= leftsum+nums[i];

    }
    return -1;
}
}