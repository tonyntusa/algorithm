package arrays_hashing;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 https://leetcode.com/problems/top-k-frequent-elements/

 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.


 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Medium_347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        Idea: with INPUT ARRAY - [1,1,1,2,2,3,1,2]
            - Step1: Use Map to count number of items appears on array
                {1: 4, 2: 3, 3: 1}
					1: appears 4 times
					2: appears 3 times
					.....
            - Step2: Use Priority Queue with PRIORITY = count number of an item
                Pair<1, 4>
                Pair<2, 3>
                Pair<3, 1>
                Queue [...,...,Pair<1, 4>] --> When poll(), the pair <1, 4> will get out to Queue first, then Pair<2, 3>, .....
            - Step3: Get k most frequent elements to result (Ex: k=2)
                res = [Pair<1, 4>.getKey() = 1, Pair<2, 3>.getKey() = 2]

            NOTE: Queue use
                offer --> add
                poll --> get and remove
        */

        // Step1:
        // Count number of num appear on the array nums
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step2:
        // Create priority Queue order by max count
        Queue<Pair<Integer, Integer>> priority = new PriorityQueue<>(
                // priority by count of a number/item. SO, when we poll from the queue, the pair with bigger count of item will get out first
                (a, b) -> b.getValue() - a.getValue()
        );

        // Loop for map to insert PAIR into priority queue BASED ON priority is bigger count of item
        for(int key : map.keySet()){
            priority.offer(new Pair<Integer, Integer>(key, map.get(key)));
        }

        // Step3:
        // Return data
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = priority.poll().getKey();
        }

        return res;
    }
}
