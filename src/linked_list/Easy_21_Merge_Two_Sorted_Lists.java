package linked_list;

/**
 https://leetcode.com/problems/merge-two-sorted-lists/

 You are given the heads of two sorted linked lists list1 and list2.

 Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

 Return the head of the merged linked list.



 Example 1:


 Input: list1 = [1,2,4], list2 = [1,3,4]
 Output: [1,1,2,3,4,4]
 Example 2:

 Input: list1 = [], list2 = []
 Output: []
 Example 3:

 Input: list1 = [], list2 = [0]
 Output: [0]


 Constraints:

 The number of nodes in both lists is in the range [0, 50].
 -100 <= Node.val <= 100
 Both list1 and list2 are sorted in non-decreasing order.
 */

// https://youtu.be/N8WTaSSivEI?list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&t=349
public class Easy_21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        IDEA: Use 2 pointer
                - dummy = new Node
                - current = dummy

                - Update current = l1 Or l2 WHEN MOVE l1 or l2 next, we
                    + current = l1 or l2
                    + l1 = l1.next OR l2 = l2.next
        */

        // Define dummy and cur node
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        // Traverse both l1 and l2 pointer through l1 and l2 linked list
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1; // linked cur with l1
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;  // linked cur with l2
                cur = l2;
                l2 = l2.next;
            }
        }

        /*
           cur  l1
        1 2 4
        1 3 4 5 7 8 9
              l2
        */
        if(l1 == null){
            // l1 pointer to end of l1 linked list. Cur will linked to rest of another from l2
            cur.next = l2;
        } else if (l2 == null) {
            // l2 pointer to end of l2 linked list. Cur will linked to rest of another from l1
            cur.next = l1;
        }

        return dummy.next;
    }
}
