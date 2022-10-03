package trees;

/**
 https://leetcode.com/problems/validate-binary-search-tree/

 Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 A valid BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:


 Input: root = [2,1,3]
 Output: true
 Example 2:


 Input: root = [5,1,4,null,null,3,6]
 Output: false
 Explanation: The root node's value is 5 but its right child's value is 4.


 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 -231 <= Node.val <= 231 - 1
 */
public class Medium_98_Validate_Binary_Search_Tree {
    /*
    https://youtu.be/kR5AxWHa9nc?t=361

    IDEA:   - User validate(Node, min, max) as helper method to check
            - Check val with min and max
                if(min != null && root.val >= min) --> return false;
                if(max != null && root.val <= max) --> return false;

            - Update min and max when validating with left and right nodes
                + min use for left
                + max use for right
    */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer min, Integer max) {
        // base case
        if(root == null)
            return true;

        // base case - check val with min and max
        // if((min != null && root.val >= min) || (max != null && root.val <= max)) return false;
        if(min != null && root.val >= min)
            return false;

        if(max != null && root.val <= max)
            return false;

        // Update min and max when validating with left and right nodes
        // min use for left
        // max use for right
        return validate(root.left, root.val, max) &&
                validate(root.right, min, root.val);
    }
}
