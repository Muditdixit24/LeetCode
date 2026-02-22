class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       
        return countAtMost(nums,k)-
        countAtMost(nums,k-1);
    }
    private int countAtMost(int[]nums,int k){
        if(k<0)
        return 0;
        int left=0;
        int right=0;
        int oddcount=0;
        int count=0;
        int n= nums.length;
        while(right<n){
            if(nums[right]%2==1){
               oddcount++;
            }
            while(oddcount>k){
                if(nums[left]%2==1){
                    oddcount--;
                }
                left++;
            }
            count= count+(right-left+1);
            right++;
        }
        return count;
    }
}