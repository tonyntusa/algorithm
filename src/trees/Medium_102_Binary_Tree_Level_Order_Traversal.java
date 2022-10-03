package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 https://leetcode.com/problems/binary-tree-level-order-traversal/

 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [[3],[9,20],[15,7]]
 Example 2:

 Input: root = [1]
 Output: [[1]]
 Example 3:

 Input: root = []
 Output: []


 Constraints:

 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000
 */
public class Medium_102_Binary_Tree_Level_Order_Traversal {
    /*
    https://youtu.be/sFDNL6r5aDM?t=82

    IDEA:   - Use BFS and Queue
            - level = queue.size(). USE this level(temp) parameter to add all node values into list_of_an_level
            while(!queue.isEmpty()){
                level = queue.size() // get level of queue

                // Add all from one level to listOfLevel
                // Add left and right node to queue
                for(i --> level){

                }
            }
    */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        // Add root node into queue first to initial the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS
        while(!queue.isEmpty()){
            // Get level
            int level = queue.size();

            // Add all from one level to listOfLevel
            // Add left and right node to queue
            List<Integer> listLevel = new LinkedList();
            for(int i=0;i<level;i++){
                TreeNode node = queue.poll();
                listLevel.add(node.val);

                // Add left and right to queue
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            res.add(listLevel);
        }

        return res;
    }
}
