package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {

    private final int[][] board = new int[9][9];
    private  final  Random random = new Random();
//    private final List<SudokuRow> rows = new ArrayList<>();

    public void fillRandomValues(int howMany){
        int count = 0;

        while(count < howMany){
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            int value = 1 + random.nextInt(9);

            if(board[row][col] == 0){
                board[row][col] = value;
                count++;
            }
        }
    }

    public SudokuBoard() {
        fillRandomValues(20);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) sb.append("+-------+-------+-------+\n");
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) sb.append("| ");
                sb.append(board[r][c] == 0 ? ". " : board[r][c] + " ");
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+");
        return sb.toString();
    }
}