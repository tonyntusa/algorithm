package trees;

/**
 https://leetcode.com/problems/balanced-binary-tree/

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: true
 Example 2:


 Input: root = [1,2,2,3,3,null,null,4,4]
 Output: false
 Example 3:

 Input: root = []
 Output: true


 Constraints:

 The number of nodes in the tree is in the range [0, 5000].
 -104 <= Node.val <= 104
 */
public class Easy_110_Balanced_Binary_Tree {
    /*
    https://youtu.be/OgdYyBT8iU8?t=210
        IDEA: use heigh(Node) as helper method --> T: O(N)
        + Bottom Up:
            balance_facter = height_left - height_right
            if(balance_facter < 1) return -1;

    */
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null)
            return true;

        return height(root) != -1? true : false;
    }

    // Return -1 it mean at NODE, it is NOT balanced
    private int height(TreeNode node){
        // base case
        if(node == null)
            return 0;

        // height of left node
        int left = height(node.left);
        if(left == -1) return -1;

        // height of left node
        int right = height(node.right);
        if(right == -1) return -1;

        // balance_facter = height_left - height_right
        int balanceFactor = Math.abs(left - right);
        if(balanceFactor > 1) // if(balanceFactor > 1 || left == -1 || right == -1)
            return -1;

        return 1 + Math.max(left, right);
    }

    /*
    https://youtu.be/OgdYyBT8iU8?t=210
        IDEA: use heigh(Node) as helper method
        + Top Down: use heigh(Node) as helper method --> O(N2)
    */
    /*
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null)
            return true;

        // base case
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        // base case
        if(node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
    */
}
