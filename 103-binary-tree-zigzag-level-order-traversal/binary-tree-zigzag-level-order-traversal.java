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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean lefttoright=true;
        while(!q.isEmpty()){
              int size=q.size();
              ArrayList<Integer>ans=new ArrayList<>();
              for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(lefttoright){
                    ans.addLast(curr.val);
                }
                else{
                ans.addFirst(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
              }
              list.add(ans);
              lefttoright=!lefttoright;
        }
        return list;
    }
}