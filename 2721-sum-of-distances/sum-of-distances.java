import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        
        for (List<Integer> indices : map.values()) {
            int size = indices.size();

            
            long[] prefix = new long[size + 1];
            for (int i = 0; i < size; i++) {
                prefix[i + 1] = prefix[i] + indices.get(i);
            }

            
            for (int i = 0; i < size; i++) {
                long idx = indices.get(i);

                long left = idx * i - prefix[i];
                long right = (prefix[size] - prefix[i + 1]) - idx * (size - i - 1);

                res[(int) idx] = left + right;
            }
        }

        return res;
    }
}