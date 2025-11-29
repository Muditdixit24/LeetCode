class Solution {
    public int minOperations(int[] nums, int k) {

        int sum = 0;

       
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        
        if (sum % k == 0) {
            return 0;
        } else {
            int min = 0;

            
            while (sum % k != 0) {
                sum--;
                min++;
            }

            return min;
        }
    }
}
