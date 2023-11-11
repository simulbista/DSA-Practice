package Intervals;

//56. Merge Intervals (Medium)

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//Constraints:
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for(int i=1; i< intervals.length; i++){
            if(currentInterval[1] >= intervals[i][0]){
                currentInterval[1] = Math.max(currentInterval[1],intervals[i][1]);
            }else{
                //add non overlapping interval to result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        //add the last interval
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{4,5}};
        int[][] result = merge(intervals);

        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }
    }
}
