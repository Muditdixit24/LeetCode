class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int zeroscount=0;
        int maxlength=0;
        while(right<nums.length){
            if(nums[right]==0){
                zeroscount++;
            }
            while(zeroscount>k){
                if(nums[left]==0){
                  zeroscount--;
                }
                left++;
            }
            right++;
            maxlength= Math.max(maxlength,right-left);
        }
        return maxlength;
    }
}