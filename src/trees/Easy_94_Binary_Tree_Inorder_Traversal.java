package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    https://youtu.be/QxFOR8sQuB4?list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&t=97

    IDEA: Recursive DFS to traverse Inorder (LEFT, ROOT, RIGHT)
        - dfs(root, results list){}

        NOTE: 3 types of Traversal
            + Inorder Traversal (LEFT, ROOT, RIGHT)
            + PreOrder Traversal (ROOT, LEFT, RIGHT)
            + PostOrder Traversal (RIGHT, LEFT, ROOT)
    */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();

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

    /*
    https://youtu.be/QxFOR8sQuB4?list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&t=78

    IDEA: We can use stack (OR RECURSIVE) to InOrder (LEFT, ROOT, RIGHT)
        - Stack<TreeNode> stack = new Stack<>();
        - while(!stack.isEmpty() || curNode != null){
            // Add left nodes and root to stack
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            // Pop node out of stack and ADD to list result
            curNode = stack.pop();

            // Update pointer to right
            curNode = curNode.right
        }
    */
    public List<Integer> inorderTraversalIterator(TreeNode root) {
        List<Integer> res = new LinkedList();

        // Initial a stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        // InOrder traversal (LEFT, ROOT, RIGHT)
        while(!stack.isEmpty() || curNode != null){
            // LEFT nodes AND root will be added to stack
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            // Pop value out of statck and ADD to list result
            curNode = stack.pop();
            res.add(curNode.val); // ADD to list after poping from stack

            // Move pointer to RIGHT
            curNode = curNode.right;
        }

        return res;
    }
}
