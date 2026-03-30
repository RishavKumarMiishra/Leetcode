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
    public int goodNodes(TreeNode root) {
        return find(root, Integer.MIN_VALUE);
    }

    public int find(TreeNode root, int val) {

        int ans = 0;
        if (root.left != null) {
            ans += find(root.left, Math.max(val, root.val));
        } 
        if (root.right != null) {
            ans += find(root.right, Math.max(val, root.val));
        }

        if (root.val >= val) ans++;
        return ans;
    }
}