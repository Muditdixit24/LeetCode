class Solution {
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root,max);
        return max[0];
    }
      private int maxPathSum(TreeNode root, int[] max){
        if(root== null)
        return 0;
         int left = Math.max(0,maxPathSum(root.left,max));
         int right = Math.max(0,maxPathSum(root.right,max));
         int current = left+right+root.val;
         max[0]= Math.max(max[0],current);
         return Math.max(left,right)+ root.val;
        
    }
}