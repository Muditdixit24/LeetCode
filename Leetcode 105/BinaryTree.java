
import java.util.*;

public class BinaryTree {

   
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inorderMap;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderMap.get(rootValue);

        root.left = helper(preorder, left, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, right);

        return root;
    }
}
