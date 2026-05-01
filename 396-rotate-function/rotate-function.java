class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int f=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            f=f+i*nums[i];
        }
        int max=f;
        for(int i=nums.length-1;i>0;i--){
            f=f+sum-nums.length*nums[i];
            max=Math.max(max,f);
        }
        return max;
    }
}