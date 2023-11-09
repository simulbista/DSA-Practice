package HashMap;

//219. Contains Duplicate II

import java.util.HashSet;
import java.util.Set;

//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-109 <= nums[i] <= 109
//0 <= k <= 105
public class ContainsDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        //sliding window to check if the abs(i-j)<=k

        int l=0;

        for(int r=0;r<nums.length;r++){
            //decrease the window
            if(r-l > k){
                window.remove(nums[l]);
                l++;
            }
            if(window.contains(nums[r])) return true;
            window.add(nums[r]);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1}; int k = 3;
//        int[] nums = {1,2,3,1,2,3}; int k = 2;

        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
