//238. Product of Array Except Self (Medium)

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
//
//
//Constraints:
//
//2 <= nums.length <= 105
//-30 <= nums[i] <= 30
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//
//Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int prefix = 1;
        int postfix = 1;
        for(int i=0;i<n;i++){
            ans[i] = prefix;
            prefix *=nums[i];
        }

        for(int i=n-1;i>=0;i--){
            ans[i] *=postfix;
            postfix*=nums[i];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
