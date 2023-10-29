package HashMap;

//290. Word Pattern (Easy)

//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//
//
//Example 1:
//
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//Example 2:
//
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
//Example 3:
//
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
//
//
//Constraints:
//
//1 <= pattern.length <= 300
//pattern contains only lower-case English letters.
//1 <= s.length <= 3000
//s contains only lowercase English letters and spaces ' '.
//s does not contain any leading or trailing spaces.
//All the words in s are separated by a single space.

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i=0; i< pattern.length();i++){
            char c = pattern.charAt(i);
            String w = words[i];

            if(charToWord.containsKey(c) && !charToWord.get(c).equals(w)) return false;
            if(wordToChar.containsKey(w) && wordToChar.get(w) != c) return false;

            charToWord.put(c,w);
            wordToChar.put(w,c);
        }
        return true;
    }

    public static void main(String[] args){
        String pattern = "abba"; String s = "dog cat cat dog";
//        String pattern = "aaaa"; String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern,s));
    }
}
