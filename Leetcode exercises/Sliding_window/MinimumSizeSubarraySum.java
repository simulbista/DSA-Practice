package Sliding_window;

//209. Minimum Size Subarray Sum (Medium)

//Given an array of positive integers nums and a positive integer target, return the minimal length of a
//subarray
// whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//
//
//
//Example 1:
//
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//Example 2:
//
//Input: target = 4, nums = [1,4,4]
//Output: 1
//Example 3:
//
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
//
//
//Constraints:
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
//
//
//Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int l=0; int sum=0;
        int result=Integer.MAX_VALUE;

        for(int r=0; r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                result = Math.min(r-l+1,result);
                sum-=nums[l];
                l++;
            }
        }

        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args){
//        int target = 7; int[] nums = {2,3,1,2,4,3};
//        int target = 4; int[] nums = {1,4,4};
//        int target = 11; int[] nums = {1,1,1,1,1,1,1,1};
        int target = 213; int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};

        System.out.println(minSubArrayLen(target,nums));
    }
}
