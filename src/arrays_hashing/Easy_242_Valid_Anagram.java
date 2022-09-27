package arrays_hashing;

/**
 https://leetcode.com/problems/valid-anagram/

 Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:
 Input: s = "anagram", t = "nagaram"
 Output: true

 Example 2:
 Input: s = "rat", t = "car"
 Output: false
 */
public class Easy_242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        /**
            Idea:
                - Every character will map to a number. We can use an array as BUCKET index for (int)character
                    [0,0,0.... 0] (256 index)
                     0 1 2.   255

                    a=97 --> index 97, put it into array BUCKET at index 97
                    [0,0,0..1.. 0] (256 index)
                     0 1 2. 97  255
        */
        // Check when s OR t is null
        // s = null; t ="abc"
        // s = "test"; t = null
        if(s == null || t == null)
            return s == t;

        // s and t is difference length
        if(s.length() != t.length())
            return false;

        // https://gym.gkmke.sk/informatika/1.rocnik/ascii.htm
        // Create array with 256 character index
        int[] characters = new int[256];
        for(int i=0; i<s.length(); i++){
            characters[(int)s.charAt(i)]++;
            characters[(int)t.charAt(i)]--;
        }

        for(int i=0; i<256; i++){
            if(characters[i] != 0)
                return false;
        }

        return true;
    }

    /**
    public boolean isAnagram(String s, String t) {
        // IDEA: Use HASH to store characters and their numbers found

        // Check when s OR t is null
        // s = null; t ="abc"
        // s = "test"; t = null
        if(s == null || t == null)
            return s == t;

        // s and t is difference length
        if(s.length() != t.length())
            return false;

        // Use a hash to count number of character in a string
        // "anagram" --> {a: 3, n:1, g: 1, r:1, m:1}
        Map<Character, Integer> hash = new HashMap<>();

        // Loop s to count number of characters
        // "anagram" --> {a: 3, n:1, g: 1, r:1, m:1}
        for(int i=0; i<s.length();i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Loop t to update number of characters in the HASH
        for(int i=0; i<t.length();i++){
            if(!hash.containsKey(t.charAt(i))){
                // The character NOT see on HASH --> false
                return false;
            }


            // Found the character in the HASH, then we reduce the NUMBER to -1
            hash.put(t.charAt(i), hash.get(t.charAt(i)) - 1);

            // If NUMBER of character in the HASH is ZERO --> Remove the character out of the HASH
            if(hash.get(t.charAt(i)) == 0)
                hash.remove(t.charAt(i));
        }

        // LOOP s --> Add to HASH
        // LOOP t --> Remove to HASH
        // If hash isEMPTY --> true, else false
        return hash.isEmpty() ? true : false;
    }
    */
}
