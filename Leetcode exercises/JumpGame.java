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
