class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int totalsum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
            if(map.containsKey(totalsum-k)){
                count+=map.get(totalsum-k);
            }
            map.put(totalsum,map.getOrDefault(totalsum,0)+1);
        }
        return count;
    }
}