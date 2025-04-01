package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private final List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public SudokuElement getElement(int row, int col) {
        return rows.get(row).getElement(col);
    }

    public SudokuRow getRow(int row) {
        return rows.get(row);
    }

    public boolean isValidPlacement(int row, int col, int value) {
        for (int c = 0; c < 9; c++) {
            if (getElement(row, c).getValue() == value) return false;
        }

        for (int r = 0; r < 9; r++) {
            if (getElement(r, col).getValue() == value) return false;
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (getElement(r, c).getValue() == value) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) sb.append("+-------+-------+-------+\n");
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) sb.append("| ");
                sb.append(getElement(r, c)).append(" ");
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+");
        return sb.toString();
    }
}
