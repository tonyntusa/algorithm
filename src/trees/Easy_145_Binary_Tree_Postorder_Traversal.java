package trees;

import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/binary-tree-postorder-traversal/

 Given the root of a binary tree, return the postorder traversal of its nodes' values.



 Example 1:


 Input: root = [1,null,2,3]
 Output: [3,2,1]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [1]
 Output: [1]


 Constraints:

 The number of the nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Easy_145_Binary_Tree_Postorder_Traversal {
    /*
    IDEA: Use RECURSIVE dfs (LEFT, RIGHT, ROOT)
        dfs(root, results List)
            dfs(left, res)      // LEFT
            dfs(right, res)     // RIGHT
            res.add(root.val)   // ROOT
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        // base case
        if(root == null) return;

        // 1 - LEFT
        dfs(root.left, res);

        // 2 - RIGHT
        dfs(root.right, res);

        // 3 - ROOT
        res.add(root.val);
    }
}
