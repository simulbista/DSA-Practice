package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//57. Insert Interval (Medium)

//You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//
//Constraints:
//
//0 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 105
//intervals is sorted by starti in ascending order.
//newInterval.length == 2
//0 <= start <= end <= 105
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add intervals that come before newInterval
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }

        //now we know that we have already added all the preceding elements from intervals in the result
        //so at this ith position, we know there is an overlap, just need to determine till which point
        // Merge overlapping intervals
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        result.add(newInterval);

        // Add remaining non overlapping intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

//        int[][] intervals = {{1, 2},{3, 5},{6, 7},{8, 10},{12, 16}};
//        int[] newInterval = {4,8};

        int[][] result = insert(intervals, newInterval);

        for(int[] interval: result){
            System.out.println(Arrays.toString(interval));
        }
    }
}
