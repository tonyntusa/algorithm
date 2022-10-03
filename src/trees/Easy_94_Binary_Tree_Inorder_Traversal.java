package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 https://leetcode.com/problems/binary-tree-inorder-traversal/

 Given the root of a binary tree, return the inorder traversal of its nodes' values.



 Example 1:


 Input: root = [1,null,2,3]
 Output: [1,3,2]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [1]
 Output: [1]


 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Easy_94_Binary_Tree_Inorder_Traversal {
    /*
    https://www.youtube.com/watch?v=o_T8MswDI_Y&list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&index=5&ab_channel=FisherCoder

    IDEA: Recursive DFS to traverse Inorder (LEFT, ROOT, RIGHT)
        - dfs(root, results list)
            dfs(left, res)      // LEFT
            res.add(root.val)   // ROOT
            dfs(right, res)     // RIGHT

        NOTE: 3 types of Traversal
            + Inorder Traversal (LEFT, ROOT, RIGHT)
            + PreOrder Traversal (ROOT, LEFT, RIGHT)
            + PostOrder Traversal (RIGHT, LEFT, ROOT)
    */

    public List<Integer> inorderTraversal(TreeNode root) {
        // Why we use LinkedList (NOT ArrayList)
        // It's because we only want to insert value to List (We don't want to get)
        // Insert to LinkedList is O(1)
        List<Integer> res = new LinkedList<>();

        // DFS
        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) return;

        // LEFT
        dfs(root.left, res);

        // ROOT
        res.add(root.val);

        // LEFT
        dfs(root.right, res);
    }
}
