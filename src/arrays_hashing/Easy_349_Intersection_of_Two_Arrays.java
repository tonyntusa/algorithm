package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/problems/intersection-of-two-arrays/

 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Explanation: [4,9] is also accepted.


 Constraints:

 1 <= nums1.length, nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 1000
 */
public class Easy_349_Intersection_of_Two_Arrays {
    /*
    https://www.youtube.com/watch?v=XxStWmfXJRs&list=PLK0ZC7fyo01J1CME35O63RhnQS2HDddWW&index=4&ab_channel=FisherCoder

    IDEA: USE SET
        - Solution1: Has SET1 and SET2 to store all element of nums1 and nums2. Use set1.retainAll(set2)
        - Solutonn2: Has set1 and set2 (OR intersection)
            + Insert all nums1 into set2
            + Loop through nums2
                if(set1.contains(num2)) --> then add to intersection set
            + Get result form intersection SET
        - USE two pointer if TWO array sorted
    */

    public int[] intersection(int[] nums1, int[] nums2) {
        // Make sure first nums parameter is smaller second one len(nums1) < len(nums2)
        if(nums1.length > nums2.length){
            return intersection(nums2, nums1);
        }

        // Put all values of nums1 into SET1
        Set<Integer> set1 = new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }

        // Compare nums2 values before inserting into Intersection SET
        Set<Integer> intersect = new HashSet<>();
        for(int num: nums2){
            if(set1.contains(num)) intersect.add(num);
        }

        // Return result
        int[] res = new int[intersect.size()];
        int i = 0;
        for(Integer num: intersect){
            res[i++] = num;
        }

        return res;
    }
}
