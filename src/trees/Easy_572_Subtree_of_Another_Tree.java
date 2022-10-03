package trees;

/**
 https://leetcode.com/problems/subtree-of-another-tree/

 Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

 A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.



 Example 1:


 Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 Output: true
 Example 2:


 Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 Output: false


 Constraints:

 The number of nodes in the root tree is in the range [1, 2000].
 The number of nodes in the subRoot tree is in the range [1, 1000].
 -104 <= root.val <= 104
 -104 <= subRoot.val <= 104
 */
public class Easy_572_Subtree_of_Another_Tree {
    /*
    https://www.youtube.com/watch?v=E36O5SWp-LE&ab_channel=NeetCode

    IDEA: use isSameTree() as helper method to check

    */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case
        if(subRoot == null)
            return true;
        if(root == null)
            return false;

        // If it's same tree
        if(isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        // base case
        if(s == null || t == null)
            return s == t;

        // Same tree WITH value the same
        if(s.val != t.val)
            return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
