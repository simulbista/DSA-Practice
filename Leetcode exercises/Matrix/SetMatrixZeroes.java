package Matrix;

//73. Set Matrix Zeroes (Medium)

//Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
//
//You must do it in place.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
//Example 2:
//
//
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//-231 <= matrix[i][j] <= 231 - 1
//
//
//Follow up:
//
//A straightforward solution using O(mn) space is probably a bad idea.
//A simple improvement uses O(m + n) space, but still not the best solution.
//Could you devise a constant space solution?
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean tempRowZero = false;

        //logic to zero the first row or the first column based on the existence of the adjacent 0s in the matrix
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(matrix[r][c] ==0){
                    matrix[0][c] =0;
                    if(r>0)  matrix[r][0] = 0;
                    else tempRowZero = true;
                }
            }
        }

        //now based on if the first row or the first col has 0, we zero out everything else
        //we dont check for 0s in the first column and first row - we do it on the next iteration
        for(int r=1;r<row;r++){
            for(int c=1;c<col;c++){
                //if first row or first column value is 0 then we need to set 0
                if(matrix[0][c] ==0 || matrix[r][0] ==0){
                    matrix[r][c] =0;
                }
            }
        }

        //checking for 0s in the first column
        if(matrix[0][0] ==0){
            for( int r=0;r<row;r++){
                matrix[r][0]=0;
            }
        }

        //checking for 0s in the first row
        if(tempRowZero){
            for(int c=0;c<col;c++){
                matrix[0][c]=0;
            }
        }

    }

    public static void main(String[] args){
//        int[][] matrix = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
