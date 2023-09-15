// 189 - Rotate Array (Easy)

//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
//0 <= k <= 105
//
//
//Follow up:
//
//Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//Could you do it in-place with O(1) extra space?
public class RotateArray {
    //logic: [1,2,3,4,5,6,7] -> k=3 -> [5,6,7,1,2,3,4]
    // reverse the entire array: [7,6,5,4,3,2,1]
    //reverse part 1 of the array upto k-1th item i.e. [7,6,5] -> [5,6,7]
    //reverse part 2 of the array i.e from kth item to the last item i.e. [4,3,2,1] -> [1,2,3,4]
    //result: [5,6,7,1,2,3,4]
    public static void rotateArray(int[] nums, int k) {
        k = k%nums.length; // (if k is greater than the nums length)if k=10, we want k=10%7=3rd index, hence we use mod
//        step1: reverse the entire array
        reverse(nums,0,nums.length-1);
//        step2: reverse the first part of the array
        reverse(nums,0,k-1);
//        step3: reverse the second part of the array
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start <end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        int[] nums = {-1,-100,3,99};
//        int k = 2;

        rotateArray(nums,k);
        for(int n : nums){
            System.out.println(n);
        }
    }

}
