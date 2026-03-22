class Solution {
    public int splitArray(int[] nums, int k) {
        int n= nums.length;
        if(k>n) return -1;
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            low= Math.max(low,nums[i]);
            high+=nums[i];
        }
        int ans=-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(ispossible(nums,n,k,mid)){
                ans= mid;
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean ispossible(int[]nums,int n, int k,
     int maxpages){
        int students=1;
        int pages=0;
        for(int i=0;i<n;i++){
            if(pages+nums[i]<=maxpages){
                pages=pages+nums[i];
            }
            else{
                students++;
                pages= nums[i];
            }
        }
        return students<=k;
    }
    }
