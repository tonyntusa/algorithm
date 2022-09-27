package two_pointers;

/**
 https://leetcode.com/problems/container-with-most-water/

 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 Find two lines that together with the x-axis form a container, such that the container contains the most water.

 Return the maximum amount of water a container can store.

 Notice that you may not slant the container.



 Example 1:


 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49
 Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 Example 2:

 Input: height = [1,1]
 Output: 1


 Constraints:

 n == height.length
 2 <= n <= 105
 0 <= height[i] <= 104
 */
public class Medium_11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        /*
        Idea: Use two pointer (left, right) to find lines heigher another one TO caculate maximum amount of water BETWEEN 2 of them
                 0 1 2 3 4 5 6 7 8
                [1,8,6,2,5,4,8,3,7]
                 l               r   max = min(1, 7)=1 * (8-0) = 8 // max = Math.max(max, Math.min(height[left], height[right]))
                   l             r   max = min(8, 7)=7 * (8-1) = 7 * 7 = 49 // max = Math.max(max, Math.min(height[left], height[right]))
                   l           r     ..... max = Math.max(max, Math.min(height[left], height[right]))
                   ................
                   ................

            maximum amount of water BETWEEN height[left] and height[right]
                min = Math.min(height[left], height[right])
                max = Math.max(max, min * (right - left))


        */

        // define pointers
        int left = 0, right = height.length-1;
        int min2Lines = 0;

        int max = Integer.MIN_VALUE;
        while(left < right){
            // Min of 2 lines at index left and right
            min2Lines = Math.min(height[left], height[right]);

            // Max OF min2Lines * (right - left)
            max = Math.max(max, min2Lines * (right - left));

            // Update pointer to choose heigher line AND continue to caculate maximum amount of water
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
