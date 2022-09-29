package linked_list;

/**
 https://leetcode.com/problems/reverse-linked-list/

 Given the head of a singly linked list, reverse the list, and return the reversed list.



 Example 1:


 Input: head = [1,2,3,4,5]
 Output: [5,4,3,2,1]
 Example 2:


 Input: head = [1,2]
 Output: [2,1]
 Example 3:

 Input: head = []
 Output: []


 Constraints:

 The number of nodes in the list is the range [0, 5000].
 -5000 <= Node.val <= 5000
 */

// https://www.youtube.com/watch?v=N_Y12-5oa-w&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=5&ab_channel=FisherCoder
public class Easy_206_Reverse_Linked_List_Solution_2Pointers {
    public ListNode reverseList(ListNode head) {
        /*
        IDEA: We use 2 pointer
            - newHead = null
            - next_temp = cur.next (USED in WHILE): THAT USED during move cur to next. It will help to remember when cur not REVERSE
                WHILE(head != null){
                    // Step 1: Store head.next to TEMP
                    next_temp = head.next

                    // Step2: Reverse back
                    head.next = new_head

                    // Step 3: Move head and new head forward
                    new_head = head;
                    head = next_temp;
                }
        */

        // Define pointer node
        ListNode newHead = null;

        // Use head as run pointer
        while(head != null) {
            // Step 1: Store head.next to TEMP
            ListNode nextTemp = head.next;

            // Step 2:MReverse back
            head.next = newHead;

            // Step 3: Move head and new head forward
            newHead = head;
            head = nextTemp;
        }

        // Return the node that reverse. It is pre, NOT cur
        return newHead;
    }
}
