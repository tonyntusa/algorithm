package trees;

/**
 https://leetcode.com/problems/same-tree/

 Given the roots of two binary trees p and q, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



 Example 1:


 Input: p = [1,2,3], q = [1,2,3]
 Output: true
 Example 2:


 Input: p = [1,2], q = [1,null,2]
 Output: false
 Example 3:


 Input: p = [1,2,1], q = [1,1,2]
 Output: false


 Constraints:

 The number of nodes in both trees is in the range [0, 100].
 -104 <= Node.val <= 104
 */
public class Easy_100_Same_Tree {
    /*
    https://www.youtube.com/watch?v=2Pe6e0KbgFI&list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&index=2&ab_channel=FisherCoder

    IDEA: Use recursive
        - Check base case
            + if(p == null || q == null) --> return p == q
            + if(p.val != q.val) --> return false

            + recursive
                return isSameTree(p.right, q.right) & isSameTree(p.left, q.left);
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if(p == null || q == null)
            return p == q;

        if(p.val != q.val)
            return false;

        return isSameTree(p.right, q.right) & isSameTree(p.left, q.left);
    }
}
