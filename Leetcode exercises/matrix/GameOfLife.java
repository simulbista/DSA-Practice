package matrix;

//289. Game of Life (Medium)

//According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//Any live cell with fewer than two live neighbors dies as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population.
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
//
//
//
//Example 1:
//Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

//Example 2:
//
//
//Input: board = [[1,1],[1,0]]
//Output: [[1,1],[1,1]]
//
//
//Constraints:
//
//m == board.length
//n == board[i].length
//1 <= m, n <= 25
//board[i][j] is 0 or 1.
//
//
//Follow up:
//
//Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
//In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        //Truth Table
            //0 -> 0 : 0
            //1 -> 1 : 1
            //0 -> 1 : 2
            //1 -> 0 : 3

        int rows = board.length;
        int cols = board[0].length;
//        count of neighbors
        int con=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                con = countOfNeighbors(board,r,c);
                //current alive to next dead i.e. 1 -> 0 : set 3
                if(board[r][c] == 1 && !(con == 2 || con == 3)){
                    board[r][c] = 3;
                }else if(board[r][c] == 0 && con==3){  //current dead to next live i.e. 0 -> 1 : set 2
                    board[r][c] = 2;
                }
            }
        }

        // set all the elements to 0s or 1s from our mapping by the truth table

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                //since 0 -> 1 : 2 i.e resultant [2] means the element was changed from 0 to [1]
                if(board[r][c] == 2) board[r][c] = 1;
                //since 1 -> 0 : 3 i.e resultant [3] means the element was changed from 1 to [0]
                if(board[r][c] == 3) board[r][c] = 0;
            }
        }

    }

    //helper method to count the no. of alive neighbors(1s)
    public static int countOfNeighbors(int[][] board,int r, int c){
        int count =0;
        int rows = board.length;
        int cols = board[0].length;
        // if we are trying to find neighbors for element at index [1,1] then we move from [0,0] through [2,2]
        for(int i=r-1; i<r+2;i++){
            for(int j=c-1; j<c+2;j++){
                //if the current index of the element is within the boundary, and it is not the current element ( we look for neighbors, not the element itself)
                if( (i==r && j==c) || i<0 || j<0 || i>=rows || j>=cols) continue;
                //since resultant 1 or 3 means the element was originally 1 (which means an alive neighbor)
                if(board[i][j] == 1 || board[i][j] == 3)    count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        gameOfLife(board);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
