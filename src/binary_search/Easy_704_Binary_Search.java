package binary_search;

/**
 https://leetcode.com/problems/binary-search/

 Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

 You must write an algorithm with O(log n) runtime complexity.



 Example 1:

 Input: nums = [-1,0,3,5,9,12], target = 9
 Output: 4
 Explanation: 9 exists in nums and its index is 4
 Example 2:

 Input: nums = [-1,0,3,5,9,12], target = 2
 Output: -1
 Explanation: 2 does not exist in nums so return -1


 Constraints:

 1 <= nums.length <= 104
 -104 < nums[i], target < 104
 All the integers in nums are unique.
 nums is sorted in ascending order.
 */
public class Easy_704_Binary_Search {
    public int search(int[] nums, int target) {
        /*
        IDEA: Use binary search because nums search
            - Binary Search by using
                left=0
                right=n-1
                middle = left - (right - left)/2

            - Update pointer left and right
                while(left <= right){
                    // update left and right pointer
                }
        */

        int left = 0, right = nums.length - 1;
        int mid = 0; // middle

        while(left <= right){
            // Search at middle first
            mid = left + (right - left/2);

            if(nums[mid] < target){
                // Search from right site of array to find target
                left = mid + 1;
            } else if (nums[mid] > target) {
                // Search from left site of array to find target
                right = mid - 1;
            } else {
                // Found target
                return mid;
            }
        }

        // Not found target
        return -1;
    }
}
