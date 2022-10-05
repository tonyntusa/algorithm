package arrays;

/**
 https://leetcode.com/problems/rotate-array/

 Given an array, rotate the array to the right by k steps, where k is non-negative.



 Example 1:

 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: nums = [-1,-100,3,99], k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]


 Constraints:

 1 <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1
 0 <= k <= 105


 Follow up:

 Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 Could you do it in-place with O(1) extra space?
 */
public class Medium_189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        /*
        IDEA:   - Reverse ALL array
                - Reverse from 0 to k (Reverse First part of array From 0 TO K)
                - Reverse from k to n (Reverse Seconde part of array From K to N)
                    + HOW Reverse? Reverse from 0 to n (nums, i, j)
                    while(i<j)
                        swap
                        i++
                        j--

                                                 k(k=3)
                                             1,2,3,4,5,6,7
            1. Reserve from index 0 to n - 1:7,6,5,4,3,2,1
            2. Reserve from index 0 to k - 1:5,6,7,4,3,2,1
            3. Reserve from index k to n - 1:5,6,7,1,2,3,4

            Example:
            1,2,3,4,5,6,7 AND k=3
            reverse(nums, 0, nums.length -1)
                 7,6,5,  4,3,2,1
            reverse(nums, 0, k-1)
                 5,6,7,  4,3,2,1
            reverse(nums, k, nums.length -1)
                 5,6,7,  1,2,3,4
        */

        // Check base case when K = 0, K = n --> No need to rotate
        int n = nums.length;
        if(k == 0 || k % n == 0)
            return; // No need to rotate

        // Check base case when K > n (Ex: k=17, n=7 --> k=n%k=3).
        if(k > n){
            k %= n;
        }

        reverse(nums, 0, n -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n -1);
    }

    // [1,2,3,4,5,6,7] --> [7,6,5,4,3,2,1]
    // + HOW Reverse? Reverse from 0 to n (nums, i, j)
    // while(i<j)
    //     swap
    //     i++
    //     j--
    private static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
