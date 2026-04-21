import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : allowedSwaps) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            // Get component
            List<Integer> comp = new ArrayList<>();
            dfs(i, graph, visited, comp);

            // Count source frequencies
            Map<Integer, Integer> freq = new HashMap<>();
            for (int idx : comp) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            // Match with target
            for (int idx : comp) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> comp) {
        visited[node] = true;
        comp.add(node);

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited, comp);
            }
        }
    }
}