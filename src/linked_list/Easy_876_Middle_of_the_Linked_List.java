package linked_list;

/**
 https://leetcode.com/problems/middle-of-the-linked-list/

 Given the head of a singly linked list, return the middle node of the linked list.

 If there are two middle nodes, return the second middle node.



 Example 1:


 Input: head = [1,2,3,4,5]
 Output: [3,4,5]
 Explanation: The middle node of the list is node 3.
 Example 2:


 Input: head = [1,2,3,4,5,6]
 Output: [4,5,6]
 Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


 Constraints:

 The number of nodes in the list is in the range [1, 100].
 1 <= Node.val <= 100
 */
public class Easy_876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        /*
        IDEA: Use slow and faster pointer.
            slow pointer move 1 step
            fast pointer move 2 step

            slow and fast START at HEAD

            - Unit Test:
            Case 1: Head = null     --> return slow = head = null
            Case 2: Head = 1        --> return slow = head = 1 BECAUSE WHILE loop will not execute
            Case 3: Head = 1 -> 2   --> return slow = 2 BECAUSE WHILE loop execute 1 TIME
            Case 4: Head = 1 -> 2 -> 3   --> return slow = 2 BECAUSE WHILE loop execute 1 TIME
            Case 5: Head = 1 -> 2 -> 3 -> 4  --> return slow = 3 BECAUSE WHILE loop execute 2 TIME
            Case 6: Head = 1 -> 2 -> 3 -> 4 -> 5  --> return slow = 3 BECAUSE WHILE loop execute 2 TIME

        */

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;       // Move next 1 step
            fast = fast.next.next;  // Move next 2 step
        }

        // Return slow one. It's middle
        return slow;
    }
}
