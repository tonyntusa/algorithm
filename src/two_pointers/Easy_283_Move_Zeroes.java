package two_pointers;

/**
 https://leetcode.com/problems/move-zeroes/

 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Note that you must do this in-place without making a copy of the array.



 Example 1:

 Input: nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Example 2:

 Input: nums = [0]
 Output: [0]


 Constraints:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1


 Follow up: Could you minimize the total number of operations done?
 */
public class Easy_283_Move_Zeroes {
    /*
     p=0
    [1,0,2,0,3,12]
     c=0
       p=1
    [1,0,2,0,3,12]
       c=1
       p=1                                     p=2
    [1,0,2,0,3,12] -- swap + move pointer [1,2,0,0,3,12]
         c=2                                   c=2
    ........
    ........

    IDEA:   - Use two pointers previous and current.
            - for(cur -> n) // Current run linear
                if([cur] != 0){
                    swap IF [pre] == 0
                    pre++ // pre pointer ALWAYS at FIRST index of target after swap
                }
    */
    public void moveZeroes(int[] nums) {
        int target = 0; // This target will be removed
        int pre = 0;
        for(int cur=0; cur<nums.length; cur++){
            if(nums[cur] != target){
                if(nums[pre] == target){
                    swap(nums, pre, cur);
                }
                pre++; // pre pointer ALWAYS at FIRST index of target after swap
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
