package Two_pointers;

//3. Longest Substring Without Repeating Characters (Medium)

import java.util.HashSet;
import java.util.Set;

//Given a string s, find the length of the longest
//substring
// without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int l=0;int count=0;
        Set<Character> mySet = new HashSet<>();

        for(int r=0;r<s.length();r++){
//          main logic which i was confused when i tried by myself: keep on increasing l index until you reach
            //the character which is the duplicate and remove it from the hashset
            while(mySet.contains(s.charAt(r))){
                mySet.remove(s.charAt(l));
                l++;
            }
            mySet.add(s.charAt(r));
            count = Math.max(count,r-l+1);
        }
        return count;
    }

    public static void main(String[] args){
//        String s = "bbbbb";
        String s = "pwwkew";
//        String s = "dvdf";
//          String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
