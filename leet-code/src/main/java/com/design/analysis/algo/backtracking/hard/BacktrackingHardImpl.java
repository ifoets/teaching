package com.design.analysis.algo.backtracking.hard;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingHardImpl implements IBacktrackingHard{

    /**37. Sudoku Solver**/
    @Override
    public void solveSudoku(char[][] board){
       solve(board);
    }
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; //fill at temp right
                            if (solve(board)) return true;
                            board[row][col] = '.'; //undo ie backtrack till not found permanent
                        }
                    }
                    return false;//not found any right place
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    /**51. N-Queens**/
    @Override
    public List<List<String>> solveNQueens(int n){
        boolean[] cols = new boolean[n];
        boolean[] dig1=new boolean[2*n];//row-col+n
        boolean[] dig2=new boolean[2*n];//row+col
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        List<List<String>> result = new ArrayList<>();
        backtrack(0, board, n,result,cols,dig1,dig2);
        return result;
    }
    private void backtrack(int row, char[][] board, int n, List<List<String>> result, boolean[]cols,boolean[] dig1,boolean[] dig2) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;//adding n for avoid -ve index val
            int d2 = row + col;

            if (cols[col] || dig1[d1] || dig2[d2])
                continue;

            board[row][col] = 'Q';
            cols[col] = dig1[d1] = dig2[d2] = true;

            backtrack(row + 1, board, n, result, cols, dig1, dig2);

            board[row][col] = '.';
            cols[col] = dig1[d1] = dig2[d2] = false;
        }
    }
        private List<String> construct(char[][] board) {
            List<String> list = new ArrayList<>();
            for (char[] row : board)
                list.add(new String(row));
            return list;
        }
}

