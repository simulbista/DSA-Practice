package HashMap;

//205. Isomorphic Strings (Easy)

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//Output: true
//Example 2:
//
//Input: s = "foo", t = "bar"
//Output: false
//Example 3:
//
//Input: s = "paper", t = "title"
//Output: true
//
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//t.length == s.length
//s and t consist of any valid ascii character.
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i=0; i<s.length();i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(mapST.containsKey(charS) && mapST.get(charS)!=charT) return false;
            if(mapTS.containsKey(charT) && mapTS.get(charT)!=charS) return false;

            mapST.put(charS,charT);
            mapTS.put(charT,charS);
        }
        return true;
    }

    public static void main(String[] args){
//        String s = "paper";String t = "title";
        String s = "foo";String t = "bar";

        System.out.println(isIsomorphic(s,t));
    }
}
