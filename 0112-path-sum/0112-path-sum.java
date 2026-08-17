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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //post-order traversal try karna chaiye
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        st.push(root);
        sums.push(root.val);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            int currSum = sums.pop();

            // Leaf node
            if (node.left == null && node.right == null) {
                if (currSum == targetSum) {
                    return true;
                }
            }

            if (node.right != null) {
                st.push(node.right);
                sums.push(currSum + node.right.val);
            }

            if (node.left != null) {
                st.push(node.left);
                sums.push(currSum + node.left.val);
            }
        }

        return false;
    }
}