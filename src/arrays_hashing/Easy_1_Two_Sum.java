package arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/two-sum/

 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.

 Example 1:
 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 Example 2:
 Input: nums = [3,2,4], target = 6
 Output: [1,2]

 Example 3:
 Input: nums = [3,3], target = 6
 Output: [0,1]
 * */
public class Easy_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        /**
         IDEA: Use Map to store {target - num: index}
         [2,11,15,7]
             set={
                9-2: 0
                11-2: 1
                15-2: 2
             }
         */

        // <target-num, index>
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);
        }

        return null;
    }
}
