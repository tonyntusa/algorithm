package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/3sum/

 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.



 Example 1:

 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]
 Explanation:
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 The distinct triplets are [-1,0,1] and [-1,-1,2].
 Notice that the order of the output and the order of the triplets does not matter.
 Example 2:

 Input: nums = [0,1,1]
 Output: []
 Explanation: The only possible triplet does not sum up to 0.
 Example 3:

 Input: nums = [0,0,0]
 Output: [[0,0,0]]
 Explanation: The only possible triplet sums up to 0.


 Constraints:

 3 <= nums.length <= 3000
 -105 <= nums[i] <= 105
 */
public class Medium_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        IDEA: Sorted array. Loop i-->n, each value[i] + find2Sum(sub_array_tail from i+1 -> n, -1*value)
            - Sorted array
            - Loop i --> n, each value[i] + find2Sum(sub_array_tail from i+1 -> n, -1*value)
            for(i --> n){
                // 2 pointer
                left = i + 1
                right = n - 1
                target = -1*value[i] (a = value[i])

                // Apply 2 sum sorted by using 2 pointer to FIND b + c = -a (a + b + c = 0)
            }

            [-1,0,0,0,1,1,2,2,2,-1,-4] --> [-4, -1, -1, 0, 0, 0, 1,1, 2,2,2]
            Result: [[-4,2,2],[-1,-1,2],[-1,0,1],[0,0,0]]
        */

        // Sort array
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        // Need to find a + b + c = 0
        int n = nums.length;
        for(int i=0; i<n; i++){
            // Prevent duplicates WHEN -1 -1 -1
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // We can found multiple twoSum base on target
            // [-2,0,0,0,0,2,2,2,2,2,2]
            int left = i+1, right = n-1, target = -1*nums[i];
            while(left < right){
                if(nums[left] + nums[right] > target){
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // ****************
                    // Try to find another 2 values that SUM to target
                    // These while of code below to handle this case - [-2,0,0,2,2]
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;

                    left++; right--;
                }
            }
        }

        return res;
    }
}
