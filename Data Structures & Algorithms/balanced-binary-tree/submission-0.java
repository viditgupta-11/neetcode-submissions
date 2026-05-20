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
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
