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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, new StringBuilder());
    }

    public int dfs(TreeNode node, StringBuilder s) {
        if (node == null) return 0;

        StringBuilder newS = new StringBuilder(s);
        newS.append(node.val);

        if (node.left == null && node.right == null) {
            return Integer.parseInt(newS.toString(), 2);
        }

        return dfs(node.left, newS) + dfs(node.right, newS);
    }
}