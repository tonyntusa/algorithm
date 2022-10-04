package trees;

/**
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

 Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



 Example 1:


 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 Output: 6
 Explanation: The LCA of nodes 2 and 8 is 6.
 Example 2:


 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 Output: 2
 Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 Example 3:

 Input: root = [2,1], p = 2, q = 1
 Output: 2


 Constraints:

 The number of nodes in the tree is in the range [2, 105].
 -109 <= Node.val <= 109
 All Node.val are unique.
 p != q
 p and q will exist in the BST.
 */
public class Medium_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    /*
    IDEA: Similar with Binary Search array
        - User a ponter cur = root (Use current node as root)
            + Both p and q on LEFT side of current node
                cur = cur.left
            + Both p and q on RIGHT side of current node
                cur = cur.right
            + Else (p and q NOT on the same side of current node)
                return root

        while(cur != null){
            if(both p.val, q.val > cur.val){
                cur = cur.right;
            } else if (both p.val, q.val < cur.val){
                cur = cur.left;
            } else { // both p and q NOT on the same side of current node
                return cur;
            }
        }
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while(current != null){
            if(p.val > current.val && q.val > current.val){
                // Both p and q on RIGHT side of current node
                current = current.right;
            } else if(p.val < current.val && q.val < current.val) {
                // Both p and q on LEFT side of current node
                current = current.left;
            } else {
                // p and q NOT on the same side of current node
                return current;
            }
        }

        return current;
    }

    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            // Both p and q on LEFT side of current node
            return lowestCommonAncestor_recursive(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            // Both p and q on RIGHT side of current node
            return lowestCommonAncestor_recursive(root.right, p, q);
        } else {
            // p and q NOT on the same side of current node
            return root;
        }
    }
}
