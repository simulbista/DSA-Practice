package matrix;

//48. Rotate Image (Medium)

//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
//Example 2:
//
//
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//Constraints:
//
//n == matrix.length == matrix[i].length
//1 <= n <= 20
//-1000 <= matrix[i][j] <= 1000
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int left=0;
        int right=matrix.length-1;
        while(left<right){
            int tempTopLeft;
            int top=left; int bottom=right;
//            for nxn matrix, we rotate n-1 times for each iteration
//            e.g.: for n=3; r=2 and l=0, so we rotate 2-0=2 times
            for(int i=0;i<right-left;i++){
                //save the top-left to a temp variable
                tempTopLeft = matrix[top][left+i];

                //move bottom-left to top-left position
                matrix[top][left+i]= matrix[bottom-i][left];

                //move bottom-right to bottom-left position
                matrix[bottom-i][left] = matrix[bottom][right-i];

                //move top-right to bottom-right position
                matrix[bottom][right-i] = matrix[top+i][right];

                //move the temp top-left element to top-right position
                matrix[top+i][right] = tempTopLeft;
            }
            //we haven't changed top and right because its a square matrix and inside the while loop,
            //top=left and bottom=right which changes with left and right in the same way.
            left++;right--;
        }
    }

    public static void main(String[] args){
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
