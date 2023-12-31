package Array_String;//55. Jump Game (medium)

//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.
//
//
//
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//
//Constraints:
//
//1 <= nums.length <= 104
//0 <= nums[i] <= 105

public class JumpGame {
    //logic: move from last element and traverse back, set the goal at the last index intially and slowly move the
    //goal index backward if the conditions match
    public static boolean canJump(int[] nums){
        int goal = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] + i >= goal) goal = i;
        }
        return goal==0?true:false;
    }


    public static void main(String[] args){
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
