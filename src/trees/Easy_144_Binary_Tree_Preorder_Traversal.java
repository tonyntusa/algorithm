package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 https://leetcode.com/problems/binary-tree-preorder-traversal/

 Given the root of a binary tree, return the preorder traversal of its nodes' values.



 Example 1:


 Input: root = [1,null,2,3]
 Output: [1,2,3]
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
public class Easy_144_Binary_Tree_Preorder_Traversal {
    /*
    IDEA: Use recursive approach (ROOT, LEFT, RIGHT)
        - dfs(TreeNode root, List<Integer> res)
            + res.add(root.val); // ROOT
            + dfs(root.left, res); // LEFT
            + dfs(root.right, res); // RIGHT
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        // Recursive
        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        // base case
        if(root == null)
            return;

        // ROOT
        res.add(root.val);

        // LEFT
        dfs(root.left, res);

        // RIGHT
        dfs(root.right, res);
    }

    /*
    https://youtu.be/vMHaqhiTn7Y?list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d&t=263

    IDEA: We can use Iterator OR recursive approach (ROOT, LEFT, RIGHT)
        - Interator approach by using STACK<TreeNode>
            + Add root to statck first
            + while(!statck.isEmpty){
                // ROOT
                TreeNode node = stack.pop()

                // LEFT
                if(node.right != null) stack.offer(node.right); // DO right first because STACK will get right later IF we have left

                // RIGHT
                if(node.left != null) stack.offer(node.left);
            }
    */
    public List<Integer> preorderTraversalIterator(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        // base case
        if(root == null) return res;

        // define stack and add root to stack first
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        // traverse the tree
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();

            // add to result
            res.add(top.val);

            if(top.right != null)
                stack.add(top.right);

            if(top.left != null)
                stack.add(top.left);
        }

        // return list data
        return res;
    }
}
