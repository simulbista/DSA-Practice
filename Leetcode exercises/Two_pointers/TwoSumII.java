package Two_pointers;

//167. Two Sum II - Input Array Is Sorted (Medium)

//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
//
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
//        logic : if sum of l+r > t, decrease r (since decreasing r will lower the sum)
//              : if sum of l+r <t, increase r (since increase r will increase the sum)
        int left = 0;
        int right = numbers.length-1;

        //we do this while condition since we know there is 1 solution
        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] > target) right--;
            else left ++;
        }
        return new int[] {left+1,right+1};
    }

    public static void main(String[] args){
//        int[] numbers = {2,7,11,15};int target = 9;
//        int[] numbers = {2,3,4};int target = 6;
        int[] numbers = {-1,0};int target = -1;

        int[] result = {-1,-1};
        result = twoSum(numbers,target);
        for (int r : result){
            System.out.println(r);
        }
    }
}
