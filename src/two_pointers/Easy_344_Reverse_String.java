package two_pointers;

/**
 https://leetcode.com/problems/reverse-string/

 Write a function that reverses a string. The input string is given as an array of characters s.

 You must do this by modifying the input array in-place with O(1) extra memory.



 Example 1:

 Input: s = ["h","e","l","l","o"]
 Output: ["o","l","l","e","h"]
 Example 2:

 Input: s = ["H","a","n","n","a","h"]
 Output: ["h","a","n","n","a","H"]


 Constraints:

 1 <= s.length <= 105
 s[i] is a printable ascii character.
 */
public class Easy_344_Reverse_String {
    public void reverseString(char[] s) {
        /*
        IDEA: Use to pointers
            - left=0, right=n-1
            - while(left<=right){
                swap()
                left++, right--;
              }
        */
        int left = 0, right = s.length - 1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
