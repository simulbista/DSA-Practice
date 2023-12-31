package HashMap;

//49. Group Anagrams (Medium)

import java.util.*;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Example 2:
//
//Input: strs = [""]
//Output: [[""]]
//Example 3:
//
//Input: strs = ["a"]
//Output: [["a"]]
//
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);
            if(!map.containsKey(sortedWord)) map.put(sortedWord, new ArrayList<>());

            //adding the word to the arraylist
            // adding ate or tea to arraylist of key - eat
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String[] strs = {"a"};

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> list : result) {
            for (String item : list) {
                System.out.println(item);
            }
        }

    }
}
