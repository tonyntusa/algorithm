package binary_search;

/**
 https://leetcode.com/problems/search-in-rotated-sorted-array/

 There is an integer array nums sorted in ascending order (with distinct values).

 Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

 Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 You must write an algorithm with O(log n) runtime complexity.



 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 Example 3:

 Input: nums = [1], target = 0
 Output: -1


 Constraints:

 1 <= nums.length <= 5000
 -104 <= nums[i] <= 104
 All values of nums are unique.
 nums is an ascending array that is possibly rotated.
 -104 <= target <= 104
 */
public class Medium_33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        /*
        IDEA: Use Binary Search
            - FROM middle, check the middle with left and right to KNOW which site LEFT or RIGHT is SORTED
                if([middle] == target) return result;

                If LEFT site SORTED // nums[left] <= nums[mid]
                    if(nums[left] <= target && target < nums[mid]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                else if RIGHT site SORTED // nums[mid] <= nums[right]
                    if(nums[mid] < target && target <= nums[right]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

        */

        // define pointers
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;

            // These line of code will do:
            // From middle, we will look from LEFT and RIGHT to know LEFT portion is SORTED or RIGHT portion is SORTED
            // Besides, we use target to narrow down left and right pointer
            if(nums[left] <= nums[mid]){
                // from left to mid, all elements are sorted. It means LEFT portion of mid are SORTED
                // find target belong to THIS LEFT portion or not
                // [4,5,6,7,8,9,0,1,2]
                //  l       m       r
                //  l     r            (Ex: target = 5) - YES
                //            l     r. (Ex: target = 1) - NO
                if(nums[left] <= target && target < nums[mid]){
                    // YES: target belong to LEFT portion that sorted
                    right = mid - 1;
                } else {
                    // NO: target belong to RIGHT portion (BUT we not sort it is sorted or not)
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                // from mid to right, all elements are sorted. It means RIGHT portion of mid are SORTED
                // find target belong to THIS RIGHT portion or not
                // [7,8,0,1,2,4,5,6,9]
                //  l       m       r
                //            l     r. (Ex: target = 5) - YES
                //  l     r            (Ex: target = 1) - NO
                if(nums[mid] < target && target <= nums[right]){
                    // YES: target belong to RIGHT portion that sorted
                    left = mid + 1;
                } else {
                    // NO: target belong to LEFT portion (BUT we not sort it is sorted or not)
                    right = mid - 1;
                }
            }

            // When we go here, we narrow down left and right pointer. The loop while will continue, if target found on array, we will found it at MIDDLE and return.
            // If not, we will go out of loop and RETURN -1 at the end.
        }

        return -1;
    }
}
