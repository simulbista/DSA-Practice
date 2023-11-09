package HashMap;

//128. Longest Consecutive Sequence (Medium)

import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
//
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//
//
//Constraints:
//
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestLength=0;

        //adding the numbers in the set
        for( int n: nums){
            set.add(n);
        }

        for(int n: nums){
            //check if the number is a start value (i.e. without any left neighbour)
            if(!set.contains(n-1)){
                int length = 1;
                //if the next number in sequence exists
                while(set.contains(n+length)) length++;
                longestLength = Math.max(length,longestLength);
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(nums));

    }
}
