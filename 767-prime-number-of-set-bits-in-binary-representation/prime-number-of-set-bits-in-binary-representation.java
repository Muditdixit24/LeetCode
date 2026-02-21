class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        
        for (int num = left; num <= right; num++) {
            
            int bits = Integer.bitCount(num);
            
            if (bits == 2 || bits == 3 || bits == 5 || bits 
            == 7 ||
                bits == 11 || bits == 13 || bits == 17 || 
                bits == 19) {
                
                count++;
            }
        }
        
        return count;
    }
}