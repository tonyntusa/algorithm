package binary_search;

/**
 https://leetcode.com/problems/single-element-in-a-sorted-array/

 You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

 Return the single element that appears only once.

 Your solution must run in O(log n) time and O(1) space.



 Example 1:

 Input: nums = [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:

 Input: nums = [3,3,7,7,10,11,11]
 Output: 10


 Constraints:

 1 <= nums.length <= 105
 0 <= nums[i] <= 105
 */
public class Medium_540_Single_Element_in_a_Sorted_Array {
    /*
    https://www.youtube.com/watch?v=nMGL2vlyJk0&ab_channel=TECHDOSE

    IDEA: Use Binary Search.
        - Check boundary case when result at head or tail of the array
        - Find result in middle of the array BY
            Compare [mid] with [mid+1] & mid ODD
                 || [mid] with [mid-1] & mid EVEN
                    --> result from RIGHT (Else --> result from LEFT)

        - How to know single element belong to right
            if( nums[mid] == nums[mid+1] && mid%2=0) ||
                          m=4%2=0 (ODD)
                    00 22 66 7 88
                nums[mid] == nums[mid-1] && mid%2=1) ||
                           m=1%2=1 (EVEN)
                          66 7
                    --> low = mid + 1

    */
    public int singleNonDuplicate(int[] nums) {
        // define pointer
        int left = 0, right=nums.length-1;

        // Check boundary cases
        // Array only has ONE elment
        if(right == 0){
            return nums[0];
        }

        // Array has more than ONE elment
        // Check if result at head or tail of the array. If yes, return result
        if(nums[0] != nums[1]){
            return nums[0]; // result at head
        } else if (nums[right] != nums[right-1]){
            return nums[right]; // result at tail
        }

        // Result in middle of the array
        while(left<=right){
            int mid = left + (right - left)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];

            // Detect result on left or right
            if(nums[mid] == nums[mid+1] && mid%2==0 ||
                    nums[mid] == nums[mid-1] && mid%2==1){
                // Result from RIGHT
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        // Never run here with real data
        return -1;
    }
}
