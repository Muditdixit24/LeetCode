class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums,k)-countAtMost(nums,k-1);
    }
    private int countAtMost(int[]nums,int k){
        if(k<0)
        return 0;
        int left=0;
        int right=0;
        int count=0;
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<n){
           map.put(nums[right],
           map.getOrDefault(nums[right],0)+1);
           while(map.size()>k){
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0){
                map.remove(nums[left]);
            }
            left++;
           }
           count=count+(right-left+1);
           right++;
        }
        return count;
    }
}