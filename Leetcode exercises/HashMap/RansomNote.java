package HashMap;

//383. Ransom Note (Easy)

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
//
//
//Constraints:
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote and magazine consist of lowercase English letters.

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        //logic : put the count of each characters in magazine in hashmap and then check if ransomnote characters is there
        // and if its there, then is it more than magazine

        if(ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> magazineCounts = new HashMap<>();

        for( char c: magazine.toCharArray()){
            magazineCounts.put(c,magazineCounts.getOrDefault(c,0) + 1);
        }

        for( char c: ransomNote.toCharArray()){
            if(!magazineCounts.containsKey(c) || magazineCounts.get(c)==0) return false;
            magazineCounts.put(c, magazineCounts.get(c)-1);
        }

        return true;
    }

    public static void main(String[] args){
//        String ransomNote = "a"; String magazine = "b";
        String ransomNote = "aa"; String magazine = "aab";

        System.out.println(canConstruct(ransomNote,magazine));
    }
}
