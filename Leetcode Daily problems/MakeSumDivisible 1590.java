import java.util.*;
class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        int rem =(int)(sum%p);
        if(rem==0){
            return 0;
        }
        long prefix = 0;
        int result= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<nums.length;i++){
            prefix= (prefix+nums[i])%p;
            int need = (int)(prefix - rem + p) % p;
            if(map.containsKey(need)){
                 result = Math.min(result,i -map.get(need));
            }
            map.put((int)prefix,i);
        }
        if(result==nums.length){
        return -1;
        }
        return result;
    }
}