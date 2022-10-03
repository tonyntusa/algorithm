package trees;

/**
 https://leetcode.com/problems/invert-binary-tree/

 Given the root of a binary tree, invert the tree, and return its root.



 Example 1:


 Input: root = [4,2,7,1,3,6,9]
 Output: [4,7,2,9,6,3,1]
 Example 2:


 Input: root = [2,1,3]
 Output: [2,3,1]
 Example 3:

 Input: root = []
 Output: []


 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100
 */
public class Easy_226_Invert_Binary_Tree {
    /*
    https://youtu.be/_i0jqdVkObU?t=88

    IDEA: Use recursive to swap
        swap(root)
            // base case
            if(root == null) retrun

            swap(root.left)
            swap(root.right)

            // HOW TO SWAP child nodes
            TreeNode temp = root.left
            root.left = root.right
            root.right = temp
    */
    public TreeNode invertTree(TreeNode root) {
        swap(root);

        return root;
    }

    private void swap(TreeNode root){
        // base case
        if(root == null) return;

        // LEFT swap
        swap(root.left);

        // RIGHT swap
        swap(root.right);

        // Swap child nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
