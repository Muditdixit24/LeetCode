/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode 
    root) {
        
        TreeMap<Integer, TreeMap<Integer, 
        PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); 
        
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;
            
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>
            ());
            map.get(col).get(row).offer(node.val);
            
            if (node.left != null)
                q.offer(new Tuple(node.left, row + 1, col -
                 1));
            
            if (node.right != null)
                q.offer(new Tuple(node.right, row + 1, col +
                 1));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> rows :
         map.values()) {
            List<Integer> colList = new ArrayList<>();
            
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            
            res.add(colList);
        }
        
        return res;
    }
    
    class Tuple {
        TreeNode node;
        int row, col;
        
        Tuple(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
}