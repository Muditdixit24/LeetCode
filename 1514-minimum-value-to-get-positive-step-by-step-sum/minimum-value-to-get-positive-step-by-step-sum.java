class Solution {
    public int minStartValue(int[] nums) {
        int sum=0;
        int minsum=0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            minsum= Math.min(minsum,sum);
        }
        return 1-minsum;
    }
}