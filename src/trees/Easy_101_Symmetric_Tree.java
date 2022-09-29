package trees;

/**
 https://leetcode.com/problems/symmetric-tree/

 Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



 Example 1:


 Input: root = [1,2,2,3,4,4,3]
 Output: true
 Example 2:


 Input: root = [1,2,2,null,3,null,3]
 Output: false


 Constraints:

 The number of nodes in the tree is in the range [1, 1000].
 -100 <= Node.val <= 100


 Follow up: Could you solve it both recursively and iteratively?
 */
public class Easy_101_Symmetric_Tree {
    /*
    https://www.youtube.com/watch?v=F85boSPtfKg&list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&ab_channel=FisherCoder

    IDEA: Recursive to check isSymmetric between (root.left, root.right)
        isSymmetric(left, right)
            - base case
            - check isSymmetric(left.left, right.right) & isSymmetric(left.right, right.left)
    */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return isSymmetric(root.left, root.right);
    }

    // Recusive for this method check
    private boolean isSymmetric(TreeNode left, TreeNode right){
        // base case
        if(left == null || right == null)
            return left == right;

        // base case value
        if(left.val != right.val)
            return false;

        // Check left and right of a node
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
