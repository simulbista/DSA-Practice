package Matrix;
//54. Spiral Matrix (Medium)

//Given an m x n matrix, return all elements of the matrix in spiral order.
//
//Example 1:
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//
//Example 2:
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0; int right = matrix[0].length;
        int top =0; int bottom = matrix.length;

        while(left<right && top<bottom){
            //traverse right
            for(int i=left;i<right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            //traverse bottom
            for(int i=top;i<bottom;i++){
                result.add(matrix[i][right-1]);
            }
            right--;

            //for single row or single column matrix -need to do this (i.e. end the traversal)
            if(!(left<right && top<bottom)) break;

            //traverse left
            for(int i=right-1;i>left-1;i--){
                result.add(matrix[bottom-1][i]);
            }
            bottom--;

            //traverse top
            for(int i=bottom-1;i>top-1;i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args){
        List<Integer> myList = new ArrayList<>();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };

        myList = spiralOrder(matrix);
        for(int item: myList){
            System.out.println(item);
        }
    }
}
