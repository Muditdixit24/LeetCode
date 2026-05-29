class Solution {
    public int minElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                sum=sum+num%10;
                num=num/10;
            }
            ans=Math.min(ans,sum);
        }
        return ans;
    }
}