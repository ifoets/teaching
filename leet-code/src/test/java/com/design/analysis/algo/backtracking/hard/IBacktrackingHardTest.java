package com.design.analysis.algo.backtracking.hard;

import com.design.analysis.algo.backtracking.medium.BacktrackingMediumImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IBacktrackingHardTest {

    IBacktrackingHard ibh;

    @Before
    public void init()
    {
        ibh =  new BacktrackingHardImpl();
    }

    /**37. Sudoku Solver**/
    @Test
    public void solveSudokuTest()
    {
        char[][] board=
            {
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
        char[][] expBoard=
            {
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
            };
        ibh.solveSudoku(board);
        for (int i=0;i<9;i++) {
            System.out.println(Arrays.toString(board[i]));
            Assert.assertArrayEquals(expBoard[i],board[i]);
        }
    }
    /**51. N-Queens**/
    /*(row, col)

        (0,0) (0,1) (0,2) (0,3)
        (1,0) (1,1) (1,2) (1,3)
        (2,0) (2,1) (2,2) (2,3)
        (3,0) (3,1) (3,2) (3,3)
    Diagonal values
    \  Main diagonal (top-left → bottom-right)
    /
  Anti-diagonal (top-right → bottom-left)
    Main diagonal (row - col):
        0  -1  -2  -3
        1   0  -1  -2
        2   1   0  -1
        3   2   1   0

    Anti-diagonal (row + col):
        0   1   2   3
        1   2   3   4
        2   3   4   5
        3   4   5   6
        */
    @Test
    public void solveNQueensTest()
    {
       List<List<String>> expList = List.of(List.of(".Q..","...Q","Q...","..Q."),List.of("..Q.","Q...","...Q",".Q.."));
        List<List<String>> reslutList = ibh.solveNQueens(4);
        for (int i=0;i<expList.size();i++) {
            System.out.println(reslutList.get(i));
            Assert.assertEquals(expList.get(i),reslutList.get(i));
        }
    }
}
