package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {

//    private final List<SudokuRow> rows = new ArrayList<>();


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 9; row++) {
            if(row % 3 == 0) sb.append("+-------+-------+-------+\n");
            for (int col = 0; col < 9; col++) {
                if(col % 3 == 0) sb.append("| ");
                sb.append(". ");
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+");
        return sb.toString();
    }
}
