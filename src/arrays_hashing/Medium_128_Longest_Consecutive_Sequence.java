package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/problems/longest-consecutive-sequence/

 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 You must write an algorithm that runs in O(n) time.



 Example 1:

 Input: nums = [100,4,200,1,3,2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 Example 2:

 Input: nums = [0,3,7,2,5,8,4,6,0,1]
 Output: 9


 Constraints:

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 */
public class Medium_128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        /*
        Idea: [100,4,200,1,3,2,2,1,101]
            - Step1: Use a set to store all keys of nums
                set = {100, 101, 1, 2, 3, 4, 200}
            - Step2: Loop num to start cound
            for(num: nums){
                // Find start point of Consecutive Sequence
                if(!set.contains(num - 1)){
                    start_emlement = 100 OR 1 OR 200
                    maxSoFar = 1;

                    while(found next start_elmenet){
                        startSeqElement++
                        maxSoFar++
                    }

                    max = Math.max(max, maxSoFar);
                }
            }
        */

        // Step1
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        // Step2
        int max = 0; // Max or Longest Consecutive Sequence
        for(int num: nums){
            // Find start point of Consecutive Sequence. If there is NOT any (num - 1) before num THEN the num is NOT start element
            // Ex: num = 100, compare with 99. IF not found 99 in SET then 100 is start_emlement AND we start from here to count maxSoFar
            if(!set.contains(num - 1)){
                int startSeqElement = num;
                int maxSoFar = 1;

                // Remove start_element from set BECAUSE we visited it already. It will improve performance if we remove it
                // NOTE: If we not remove start_element, solution still correct
                set.remove(startSeqElement);

                while(set.contains(startSeqElement + 1)){
                    startSeqElement++;
                    maxSoFar++;

                    // Remove start_element from set BECAUSE we visited it already. It will improve performance if we remove it
                    // NOTE: If we not remove start_element, solution still correct
                    set.remove(startSeqElement);
                }

                max = Math.max(max, maxSoFar);
            }
        }

        return max;
    }
}
