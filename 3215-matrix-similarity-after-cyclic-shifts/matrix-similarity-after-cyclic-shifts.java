class Solution {
    public boolean areSimilar(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        k = k % n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i % 2 == 0) {
                   
                    if (grid[i][j] != grid[i][(j + k) % n]) {

                        return false;
                    }
                } else {
                    
                    if (grid[i][j] != grid[i][(j - k + n) %
                     n]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}