class Robot {

    int width, height;
    int x = 0, y = 0;
    int dir = 0; 

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    String[] names = {"East","North","West","South"};

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
    }

    public void step(int num) {

        num %= perimeter;

    
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; 
            }
            return;
        }

        while (num > 0) {

            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

            
            if (nx < 0 || ny < 0 || nx >= width || ny >= 
            height) {
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return names[dir];
    }
}