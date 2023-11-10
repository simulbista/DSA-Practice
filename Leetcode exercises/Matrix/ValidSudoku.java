package Matrix;

//36. Valid Sudoku (Medium)

//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.

//Input: board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//Example 2:
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
//
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit 1-9 or '.'.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        //we use set because, if you add the same item in it multiple times, it only gets stored once unlike a list
        // i.e. it has only unique items and is unordered
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        //initialize the sets (9 for each rows,cols and squares)
        for(int i=0; i<9;i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            squares.put(i, new HashSet<>());
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char cell = board[r][c];
                if(cell == '.') continue;
                //if the item on the current cell already exists in the hashset of either the cols set, rows set or square set,
                // it means it's repeated, so return false which means the sudoku is invalid

                // important note: 3*(r/3)+c/3 gives the hashset index for the squares which goes from 0 to 9
                //where 0 is the first 3x3 matrix and 9 is the last 3x3 matrix
                if(rows.get(r).contains(cell) || cols.get(c).contains(cell) || squares.get(3*(r/3) + c/3).contains(cell))   return false;

                rows.get(r).add(cell);
                cols.get(c).add(cell);
                squares.get(3*(r/3) + c/3).add(cell);
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

//        char[][] board = {
//                {'8','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

        System.out.println(isValidSudoku(board));
    }
}
