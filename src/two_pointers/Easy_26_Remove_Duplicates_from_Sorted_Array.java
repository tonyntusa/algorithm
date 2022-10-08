package two_pointers;

/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

 Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

 Return k after placing the final result in the first k slots of nums.

 Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:

 Input: nums = [1,1,2]
 Output: 2, nums = [1,2,_]
 Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 Example 2:

 Input: nums = [0,0,1,1,1,2,2,3,3,4]
 Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).


 Constraints:

 1 <= nums.length <= 3 * 104
 -100 <= nums[i] <= 100
 nums is sorted in non-decreasing order.
 */
public class Easy_26_Remove_Duplicates_from_Sorted_Array {
    /*
    https://www.youtube.com/watch?v=Sxc9oZ3PrFU&ab_channel=EricProgramming
    https://www.youtube.com/watch?v=nRKZC2JF7LU&ab_channel=FisherCoder
     s
    [0,0,1,1,1,2,2,3,3,4]
         f
       s
    [0,1,1,1,1,2,2,3,3,4]
               f

    IDEA: Use slow and fast pointer
        slow --> ALWAYS point to UNIT element
        fast --> loop step by step

        for(fast --> n)
            if([fast] != [slow]){
                slow++;
                [slow] = [fast]
            }
    */
    public int removeDuplicates(int[] nums) {
        int slow = 0; // ALWAYS point to UNIT element

        // Fast pointer will run step by step
        for(int fast=0; fast<nums.length;fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
                //nums[++slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
