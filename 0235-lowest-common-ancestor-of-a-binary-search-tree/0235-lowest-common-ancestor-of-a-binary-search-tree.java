/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return ans;
    }

    public int lca(TreeNode root, TreeNode p, TreeNode q) {

        int count = 0;
        if (root == p || root == q) count++;
        if (root.left != null) {
            count += lca(root.left, p, q);
        }
        if (root.right != null) {
            count += lca(root.right, p, q);
        }

        if (count == 2) ans = root;
        return count == 2 ? 0 : count;
    }
} 