package slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/longest-repeating-character-replacement/

 You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

 Return the length of the longest substring containing the same letter you can get after performing the above operations.



 Example 1:

 Input: s = "ABAB", k = 2
 Output: 4
 Explanation: Replace the two 'A's with two 'B's or vice versa.
 Example 2:

 Input: s = "AABABBA", k = 1
 Output: 4
 Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 The substring "BBBB" has the longest repeating letters, which is 4.


 Constraints:

 1 <= s.length <= 105
 s consists of only uppercase English letters.
 0 <= k <= s.length
 */
public class Medium_424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        /*
        IDEA: Use slide window with left, right start at index 0
            + Use MAP to count number of times a character appears IN A WINDOW
                "AABCCACBBA" (k = 2)
                 AABCA      With this window {A:3, B:1, C:1}
            + Use paramater to store most requence character appear IN A WINDOW
                This window = AABCA      {A:3, B:1, C:1}
                    --> mostRequence = 3
            + Collapse the window from LEFT - JUST IN CASE the WINDOW is NOT VALID
                if(window_size - mostRequence > k){  // window_size = right - left + 1
                    // WINDOW NOT VALID
                    Update count from MAP
                    left++
                }

            - UnitTest Running
                AABCCACBC (k=2)
                A               {A:1}   mostReq=1 (window_size - mostReq = (left - right) - mostReq = 1 - 1 <= k) STILL VALID
                AA              {A:2}   mostReq=2 (window_size - mostReq = 2 - 1 <= k) STILL VALID
                AAB             {A:2, B:1} mostReq=2 (window_size - mostReq = 3 - 2 <= k) STILL VALID
                AABC            {A:2, B:1, C:1} mostReq=2 (4 - 2 <= k) STILL VALID
                AABCC           {A:2, B:1, C:2} mostReq=2 (5 - 2 > k) NOT VALID
                    --> {A:1, B:1, C:2} // Update Map count
                 ABCCA          {A:2, B:1, C:2} mostReq=2 (5 - 2 > k) NOT VALID
                    --> {A:1, B:1, C:2} // Update Map count
                  BCCAC         {A:1, B:1, C:3} mostReq=2 (5 - 3 <= k) VALID
                  BCCACB        {A:1, B:2, C:3} mostReq=3 (6 - 3 > k) NOT VALID
                    --> {A:1, B:1, C:3} // Update Map count
                   CCACBC       {A:1, B:1, C:4} mostReq=2 (6 - 4 <= k) VALID

                   DONE when right pointer to END --> max = 6
        */

        Map<Character, Integer> map = new HashMap<>();
        int mostReq=0; // most requence character count in A WINDOW
        int left = 0, max = 0;
        for(int right=0; right<s.length(); right++){
            // Update count for map
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // Caculate mostReq for current Window
            mostReq = Math.max(mostReq, map.get(s.charAt(right)));

            // IN-VALID window, need to collapse the window from left
            if((right - left + 1) - mostReq > k){ // IN-VALID
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            // Caculate max with window_size
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
