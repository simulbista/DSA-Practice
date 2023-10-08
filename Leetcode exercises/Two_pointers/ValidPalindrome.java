//125. Valid Palindrome - Easy

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.


package Two_pointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        //return true if its an empty string
        if(s.isEmpty()) return true;

        int start=0;
        int end=s.length()-1;

        while(start<=end){
            char currentFirst = s.charAt(start);
            char currentLast = s.charAt(end);

            if(!Character.isLetterOrDigit(currentFirst)){
                start++;
            }else if(!Character.isLetterOrDigit(currentLast)){
                end--;
            }else if(currentFirst!=currentLast){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s ="";

        System.out.println(isPalindrome(s));
    }
}
