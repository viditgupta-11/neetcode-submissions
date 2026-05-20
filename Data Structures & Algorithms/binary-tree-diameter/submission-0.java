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
    int ans = 0;
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);
        ans = Math.max(ans, lDepth + rDepth + 2);
        return 1 + Math.max(lDepth, rDepth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
}
