package linked_list;

/**
 https://leetcode.com/problems/remove-nth-node-from-end-of-list/

 Given the head of a linked list, remove the nth node from the end of the list and return its head.



 Example 1:


 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]
 Example 2:

 Input: head = [1], n = 1
 Output: []
 Example 3:

 Input: head = [1,2], n = 1
 Output: [1]


 Constraints:

 The number of nodes in the list is sz.
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz


 Follow up: Could you do this in one pass?
 */

// https://youtu.be/Kka8VgyFZfc?list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&t=386
public class Medium_19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        IDEA: Use slow (+1) and fast(+1) pointer. fast move first Nth forward. After that, they move +1 together.
            - dummy = new Node
            - slow = dummy
            - fast = dummy

            - Moving fast and slow
                + fast move first Nth time
                + slow and fast move together
            - Remove Nth by
                slow.next = slow.next.next (***** REMEMBER *****)
            - Return dummy.next
        */

        // Base case
        if(head == null) return null;

        // Define pointers
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        // Moving fast and slow.
        // Fast move first Nth forward. After that, slow & fast move +1 together.
        while(fast.next != null){
            if(n > 0){
                fast = fast.next;
                n--;
                continue;
            }

            slow = slow.next;
            fast = fast.next;
        }

        // Remove Nth Node From End of List
        slow.next = slow.next.next;

        return dummy.next;
    }
}
