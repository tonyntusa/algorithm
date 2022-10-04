package trees;

import java.util.Stack;

/**
 https://leetcode.com/problems/kth-smallest-element-in-a-bst/

 Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



 Example 1:


 Input: root = [3,1,4,null,2], k = 1
 Output: 1
 Example 2:


 Input: root = [5,3,6,2,4,null,null,1], k = 3
 Output: 3


 Constraints:

 The number of nodes in the tree is n.
 1 <= k <= n <= 104
 0 <= Node.val <= 104


 Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
public class Medium_230_Kth_Smallest_Element_in_a_BST {
    /*
    https://youtu.be/5LUXSvjmGCw?t=66

    IDEA:
        Solution1:  Use STACK to traverse BST by ITERATOR (NOT Recursive) (Similar with https://leetcode.com/problems/binary-tree-inorder-traversal)
                    BECAUSE InOrder traverse, the result we recive is SORTED [1, 2, 3, 4, 5]
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

        Solution2: Traverse InOrder BST and store values into array
            --> [1, 2, 3, 4, 5] --> k=3 --> result = arr[3]
            --> T: O(N), S: O(N)
    */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        while(!stack.isEmpty() || curNode != null){
            // Add left nodes and root to stack
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            // Pop node out of stack AND reduce k--
            curNode = stack.pop();
            k--;
            if(k == 0)
                return curNode.val;

            // Update curNode to RIGHT
            curNode = curNode.right;
        }

        // Real data, not go here
        return -1;
    }
}
