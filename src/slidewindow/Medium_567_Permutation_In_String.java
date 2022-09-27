package slidewindow;

import java.util.Arrays;

/**
 https://leetcode.com/problems/permutation-in-string/

 Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

 In other words, return true if one of s1's permutations is the substring of s2.

 Example 1:
     Input: s1 = "ab", s2 = "eidbaooo"
     Output: true
     Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
     Input: s1 = "ab", s2 = "eidboaoo"
     Output: false
 * */
public class Medium_567_Permutation_In_String {
    public boolean checkInclusion(String s1, String s2) {
        /*
        IDEA: Use slide window with window_size = s1.length to run through s2 string to find sub string that contain permutation of s1 OR not
            - Use hashArr[26] to know s1 and sub_string of s2 is permutations or not
                s1 = "aabc"
                s2 = "eidbacaooo" "eid[baca]ooo"

                                          a b c d e f ..............................................z
                s1=aabc     --> hashArr1 [2,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]      {a: appear 2 times, b: appear 1 time, c: appear 1 time}
                sub_s2=baca --> hashArr2 [2,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]      {a: appear 2 times, b: appear 1 time, c: appear 1 time}
                if(Arrays.equals(hashArr1, hashArr2)){
                    return true;
                } else {
                    Update hashArr2 everytime slide window WITH window_size = s.length = 4 // "aabc" --> size 4
                }

            - Slide window through s2 with WINDOW_SIZE = s1.length = 4
                s2 = "eidbacaooo"
                      eidb          --> one sub_string of s2 with size = s1.length = 4 THAT COMPARE to s1
                       idba
                        dbac
                         baca
                          acao
                           caoo
                            aooo
        */

        // Check specific cases (Constraints: 1 <= s1.length, s2.length <= 104)
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;

        // define hash array
        int[] hashArr1 = new int[26];
        int[] hashArr2 = new int[26];

        // Initial hashArr
        // Convert s1 and sub_string of s2 (sub_string=len1) to hash array to know them permutations or not
        for(int i=0; i<len1; i++){
            hashArr1[s1.charAt(i) - 'a']++; // aabc
            hashArr2[s2.charAt(i) - 'a']++; // eidb
        }

        // Slide window on s2 string to find sub_string of s2 and compare them with s1 (WINDOW_ZISE = len1 = 4)
        for(int i=len1; i<len2; i++){
            if(Arrays.equals(hashArr1, hashArr2)){
                return true; // sub_string of s2 PERMUTATE with s1
            }

            // Slide window and update hashArr2. We only update hashArr2 at fist and last index of sub_string of s2
            // After update hashArr2, we will COMPARE with hashArr1 (ABOVE) to know sub_s2 & s1 PERMUTATE or NOT
            // eidb
            //  idba  --> minute -1 for e AND plus +1 for a character ON hashArr2 (NO NEED touch db)
            //   dbac --> minute -1 for i AND plus +1 for c character ON hashArr2 (NO NEED touch ba)
            hashArr2[s2.charAt(i-len1) - 'a']--;
            hashArr2[s2.charAt(i) - 'a']++;
        }

        return Arrays.equals(hashArr1, hashArr2) ? true : false;
    }
}
