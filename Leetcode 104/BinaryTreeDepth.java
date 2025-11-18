class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) 
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        BinaryTreeDepth sol = new BinaryTreeDepth();
        int depth = sol.maxDepth(root);

        System.out.println("Maximum Depth = " + depth);
    }
}
