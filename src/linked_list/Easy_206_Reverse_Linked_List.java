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
public class Easy_206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        /*
        IDEA: We use 3 pointer
            - pre = null
            - cur = head
            - next_temp = cur.next (USED in WHILE): THAT USED during move cur to next. It will help to remember when cur not REVERSE

                       cur    next
            pre(NULL)   1   -> 2 -> 3 -> 4 -> NULL
                       head

        */

        // Define pointer node
        ListNode pre = null, cur = head;

        while(cur != null){
            // Remember cur.next to TEMP paramater
            ListNode nextTemp = cur.next;

            // reverse cur to pre
            cur.next = pre;

            // Move pre and cur ahead
            pre = cur;
            cur = nextTemp;
        }

        // Return the node that reverse. It is pre, NOT cur
        return pre;
    }
}
