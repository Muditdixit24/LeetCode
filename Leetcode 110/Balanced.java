
class Solution {
    public boolean isBalanced(TreeNode root) {
            return isBalancedhelper(root)!=-1;
    }
        private int isBalancedhelper(TreeNode root){
           if(root==null){
           return 0;
           }
           int left= isBalancedhelper(root.left);
           if(left==-1)
            return -1;
           int right= isBalancedhelper(root.right);
           if(right==-1)
            return -1;
           
           if(Math.abs(left-right)>1)
             return -1;
       
        return Math.max(left,right)+1;
    }
}