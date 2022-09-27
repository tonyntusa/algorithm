package slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/problems/longest-substring-without-repeating-characters/

 Given a string s, find the length of the longest substring without repeating characters.
 Example 1:
     Input: s = "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
 Example 2:
     Input: s = "bbbbb"
     Output: 1
     Explanation: The answer is "b", with the length of 1.
 Example 3:
     Input: s = "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3.
     Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Medium_3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        /*
        IDEA:   - Use two pointer left and right start at index 0
                - Use max to store max for each time to move pointers  with default max = 0
                - Use SET to store substring TO MAKE SURE NO repeating character
                    *** NOTE: KEY of SOLUTION here is we use SET to check first before making decision to move right pointer or left pointer next

                - Right pointer run to the end of s.
                - Use set to check contain OR not cointain charater to make decison to move right pointer or left pointer next
                while(right < s.length()){
                    if(!set.contains(s.charAt(right))){ // set NOT contain character at right pointer
                        + Add char at right to SET
                        + move right next
                        + caculate max = Math.max(max, right - left)
                    } else {
                        + remove char at left out of SET
                        + move left next
                    }
                }
        */

        int left=0, right=0;
        int max=0;
        Set<Character> set = new HashSet<>();

        // Use set to check contain OR not cointain charater at pointer --> make decison to move right pointer or left pointer next
        // After moving pointers, need remove repeating character out of the SET
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}
