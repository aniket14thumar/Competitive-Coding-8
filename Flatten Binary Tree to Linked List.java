// Iterative Approach

// Time Complexity : O(n)
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            
            if(curr.right != null){
                st.push(curr.right);
            }
            
            if(curr.left != null){
                st.push(curr.left);
            }
            
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            
            curr.left = null;
        }

    }
}


// Recursive Approach

// Time Complexity : O(n)
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public void flatten(TreeNode root) {
        // base
        if( root == null || (root.left == null && root.right == null)) return;
        
        // logic
        flatten(root.left);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = temp;

        flatten(root.right);
    }

} 
