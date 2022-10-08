package arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 https://leetcode.com/problems/intersection-of-two-arrays-ii/

 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Explanation: [9,4] is also accepted.


 Constraints:

 1 <= nums1.length, nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 1000


 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Easy_350_Intersection_of_Two_Arrays_II {
    /*
    https://www.youtube.com/watch?v=lKuK69-hMcc&list=PLK0ZC7fyo01J1CME35O63RhnQS2HDddWW&index=5&ab_channel=FisherCoder

    IDEA: Similar with Intersection of Two Array (https://leetcode.com/problems/intersection-of-two-arrays/submissions/)
        - Use Map
        - Has map1 and list2 (OR intersection to store result FOUND)
            + Insert all nums1 into map1 to store and count
            + Loop through nums2
                count = map1.getOrDefault(num, 0);
                if(count > 0){
                    --> then add to intersection list
                    --> Update count of MAP
                }
            + Get result form intersection list
        - USE two pointer if TWO array sorted
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Make sure we have len(nums1) < len(nums2)
        if(nums2.length < nums1.length){
            return intersect(nums2, nums1);
        }

        // Use map to count
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Use intersect list to store result FOUND
        List<Integer> list = new ArrayList<>();
        for(int num: nums2){
            int count = map.getOrDefault(num, 0);
            if(count > 0){
                list.add(num);
                map.put(num, count - 1);
            }
        }

        // Return result
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer num: list){
            res[i++] = num;
        }

        return res;
    }
}
