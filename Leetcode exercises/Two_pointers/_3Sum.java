package Two_pointers;

//15. 3Sum (Medium)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
public class _3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        //logic : loop from index 0 to 3rd last element in sorted nums, and do i+ 2sumII(of remaining nos in the list)
        //where i is the 1st no. to compare out of the 3 and the remaining two are calculated using 2SumII algorithm
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //if the first item in the sorted array is greater than 0, that means there's no way the sum can be 0 as there is no negative no.
        if(nums[0]>0) return result;
//        we loop till length-2 index since we need to have 3 no.s in total to compare
        for(int i=0;i<nums.length-2;i++){
            //if the first item (being compared) in the sorted array is greater than 0, that means there's no way the sum can be 0 as there is no negative no.
            if(nums[i]>0) return result;

            //remove duplicates for this 1st no. (if the current value is equal to previous value, then just skip it)
            if(i>0 && nums[i]==nums[i-1]) continue;
            //assign left as the next time to i and assign right as the last item in nums
            int left = i+1;
            int right = nums.length-1;
//            using TwoSumII algorithm for the 2nd and 3rd no. being compared
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum>0)   right--;
                else if(sum<0)  left++;
                //if the sum is equal to 0 i.e. the solution
                else{
                    //adding the solution to the result list
                   result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                   //to continue with the rest of the nos we increment left
                    left++;
                    //to check again for duplicate values (since we don't want to add the same triplet to the result)
                    //we only do left ++ and not right-- because doing either will take care of the other (see NeetCode video)
                    while(nums[left] ==nums[left-1] && left<right)  left++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,1,1};
//        int[] nums = {0,0,0};
        int[] nums ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> list = threeSum(nums);

        for(List<Integer> triplet: list){
                System.out.println(triplet);
        }
    }
}
