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
    public boolean isValidBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraverse(root, arr);

        for (int i=1; i<arr.size(); i++) {
            if (arr.get(i) <= arr.get(i-1)) {
                return false;
            }
        }

        return true;
        
    }

    public void inOrderTraverse(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.left, arr);
        arr.add(root.val);
        inOrderTraverse(root.right, arr);
    }
}
