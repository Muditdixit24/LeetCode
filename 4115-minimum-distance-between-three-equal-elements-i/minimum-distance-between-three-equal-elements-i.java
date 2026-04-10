class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new 
        HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>
            ()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (ArrayList<Integer> pos : map.values()) {
            for (int i = 2; i < pos.size(); i++) {
                ans = Math.min(ans, 2 * (pos.get(i) - pos.get
                (i - 2)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}