package two_pointers;

/**
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

 Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

 Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

 The tests are generated such that there is exactly one solution. You may not use the same element twice.

 Your solution must use only constant extra space.



 Example 1:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 Example 2:

 Input: numbers = [2,3,4], target = 6
 Output: [1,3]
 Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 Example 3:

 Input: numbers = [-1,0], target = -1
 Output: [1,2]
 Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


 Constraints:

 2 <= numbers.length <= 3 * 104
 -1000 <= numbers[i] <= 1000
 numbers is sorted in non-decreasing order.
 -1000 <= target <= 1000
 The tests are generated such that there is exactly one solution.
 */
public class Medium_167_Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] nums, int target) {
        /*
        IDEA: Use 2 pointer
            left = 0
            right = n - 1

            [2,7,11,15]
             l       r

            NOTE: Only while(l < r) // NO need l <= r BECAUSE we don't want l = r
            while(l < r){
                if(a + b < target){
                    // a + b > target --> Find smaller TOTAL of a + b than target by RIGHT--
                } else if (a + b > target) {
                    // a + b < target --> Find bigger TOTAL of a + b than target by LEFT++
                } else {
                    return result;
                }
            }
        */
        // Constraints: 2 <= numbers.length <= 3 * 104 --> nums OVER 2 items

        // define pointers
        int left = 0, right=nums.length - 1;

        // We just check left < right (NOT left <= right) because we don't want left = right IN 1 index
        while(left < right){
            if(nums[left] + nums[right] > target) {
                // a + b > target --> Find smaller TOTAL than target by MINUS RIGHT
                right--;
            } else if(nums[left] + nums[right] < target){
                // a + b < target --> Find bigger TOTAL than target by PLUS LEFT
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
        }

        return null;
    }
}
