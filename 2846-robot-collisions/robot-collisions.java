import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        
        int[][] robots = new int[n][2];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = i;
        }
        Arrays.sort(robots, (a, b) -> Integer.compare(a[0],
         b[0]));

        Stack<Integer> stack = new Stack<>(); 
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        for (int[] robot : robots) {
            int idx = robot[1];
            char dir = directions.charAt(idx);

            if (dir == 'R') {
                stack.push(idx);
            } else {
                
                while (!stack.isEmpty() && healths[idx] > 0) {
                    int rightIdx = stack.peek();
                    if (healths[rightIdx] < healths[idx]) {
                        
                        alive[rightIdx] = false;
                        stack.pop();
                        healths[idx]--; 
                    } else if (healths[rightIdx] == healths[idx]) {
                        
                        alive[rightIdx] = false;
                        alive[idx] = false;
                        stack.pop();
                        healths[idx] = 0;
                        break;
                    } else {
                        
                        alive[idx] = false;
                        healths[rightIdx]--; 
                        healths[idx] = 0;
                        break;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (alive[i]) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}
