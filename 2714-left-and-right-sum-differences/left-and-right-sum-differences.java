class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n= nums.length;
        int result[]= new int[n];
        
        int sum =0;
        for(int i=0;i<n;i++){
            sum = sum+nums[i];
        }
        int leftsum=0;
        for(int i=0;i<n;i++){
            int rightsum = sum-leftsum-nums[i];
            result[i]=Math.abs(leftsum-rightsum);
            leftsum= leftsum+nums[i];
        }
        return result;
    }
}