class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (dfs(grid, vis, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] grid, boolean[][] vis, int x, int y, int px, int py) {
        vis[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                continue;
            
            if (grid[nx][ny] != grid[x][y]) continue;
            
           
            if (vis[nx][ny]) {
                if (nx != px || ny != py) return true;
            } else {
                if (dfs(grid, vis, nx, ny, x, y)) return true;
            }
        }
        
        return false;
    }
}