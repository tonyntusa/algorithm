package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/problems/contains-duplicate/

 Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 Example 1:
 Input: nums = [1,2,3,1]
 Output: true

 Example 2:
 Input: nums = [1,2,3,4]
 Output: false

 Example 3:
 Input: nums = [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */
public class Easy_217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        /**
         * Idea: Use a Set to know an item appear twice
         */
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                return true;

            set.add(nums[i]);
        }

        return false;
    }
}
