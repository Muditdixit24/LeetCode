class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int count = 0;
        
        
        for (int top = 0; top < n; top++) {
            
            int[] colSum = new int[m];
            
            
            for (int bottom = top; bottom < n; bottom++) {
                
                
                for (int c = 0; c < m; c++) {
                    colSum[c] += matrix[bottom][c];
                }
                
               
                count += subarraySum(colSum, target);
            }
        }
        
        return count;
    }
    
    
    private int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}