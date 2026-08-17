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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        if(root == null){
            return list;
        }
        TreeNode curr = root;
        TreeNode temp = null;
        while(curr != null || !st1.isEmpty()){
            if(curr != null){
                st1.push(curr);
                curr= curr.left;
            }else{
                temp = st1.peek().right;
                if(temp == null){
                    temp = st1.peek();
                    st1.pop();
                    list.add(temp.val);
                    while(!st1.isEmpty() && temp == st1.peek().right){
                        temp = st1.peek();
                        st1.pop();
                        list.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }

        return list;
    }
}