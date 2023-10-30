package HashMap;

//242. Valid Anagram (Easy)

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
//
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
//
//
//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<>();

        //storing the count of the characters in String s in the map
        for( char c: s.toCharArray()){
            mapS.put(c,mapS.getOrDefault(c,0) + 1);
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);

            if(!mapS.containsKey(c) || mapS.get(c) == 0) return false;

            mapS.put(c,mapS.get(c)-1);
        }

        return true;
    }

    public static void main(String[] args){
//        String s = "anagram"; String t = "nagaram";
        String s = "rat"; String t = "car";

        System.out.println(isAnagram(s,t));
    }
}
