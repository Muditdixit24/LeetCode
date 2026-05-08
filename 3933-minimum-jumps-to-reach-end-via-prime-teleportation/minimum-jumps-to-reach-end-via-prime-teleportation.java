import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        
        int[] spf = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            Set<Integer> used = new HashSet<>();

            while (x > 1) {
                int p = spf[x];

                if (!used.contains(p)) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    used.add(p);
                }

                while (x % p == 0) {
                    x /= p;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        Set<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                
                if (val >= 2 && spf[val] == val && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    List<Integer> next = map.get(val);

                    if (next != null) {
                        for (int ni : next) {
                            if (!visited[ni]) {
                                visited[ni] = true;
                                q.offer(ni);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}