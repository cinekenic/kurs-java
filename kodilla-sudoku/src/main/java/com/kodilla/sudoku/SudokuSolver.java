package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public boolean solve(SudokuBoard board) {
        boolean progress;
        do {
            progress = eliminate(board);
            if (isComplete(board)) return true;
        } while (progress);

        return guess(board);
    }

    private boolean eliminate(SudokuBoard board) {
        boolean changed = false;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement element = board.getElement(row, col);
                if (!element.isEmpty()) continue;

                Set<Integer> toRemove = new HashSet<>();

                for (int c = 0; c < 9; c++) {
                    int val = board.getElement(row, c).getValue();
                    if (val != SudokuElement.EMPTY) toRemove.add(val);
                }

                for (int r = 0; r < 9; r++) {
                    int val = board.getElement(r, col).getValue();
                    if (val != SudokuElement.EMPTY) toRemove.add(val);
                }

                int boxRow = (row / 3) * 3;
                int boxCol = (col / 3) * 3;
                for (int r = boxRow; r < boxRow + 3; r++) {
                    for (int c = boxCol; c < boxCol + 3; c++) {
                        int val = board.getElement(r, c).getValue();
                        if (val != SudokuElement.EMPTY) toRemove.add(val);
                    }
                }

                for (int val : toRemove) {
                    if (element.getPossibleValues().contains(val)) {
                        element.removePossibleValue(val);
                        changed = true;
                    }
                }

                if (element.hasOnlyOnePossibleValue()) {
                    element.setValue(element.getSinglePossibleValue());
                    changed = true;
                }

                if (element.getPossibleValues().isEmpty() && element.isEmpty()) {
                    return false;
                }
            }
        }

        return changed;
    }

    private boolean guess(SudokuBoard board) {
        int minOptions = 10;
        int guessRow = -1;
        int guessCol = -1;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                SudokuElement el = board.getElement(r, c);
                if (el.isEmpty() && el.getPossibleValues().size() < minOptions) {
                    minOptions = el.getPossibleValues().size();
                    guessRow = r;
                    guessCol = c;
                }
            }
        }

        if (guessRow == -1) return false;

        Set<Integer> guesses = new HashSet<>(board.getElement(guessRow, guessCol).getPossibleValues());

        for (int val : guesses) {
            SudokuBoard copy = deepCopyBoard(board);
            copy.getElement(guessRow, guessCol).setValue(val);
            if (solve(copy)) {
                copyToOriginal(copy, board);
                return true;
            }
        }

        return false;
    }

    private boolean isComplete(SudokuBoard board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board.getElement(r, c).isEmpty()) return false;
            }
        }
        return true;
    }

    private SudokuBoard deepCopyBoard(SudokuBoard original) {
        SudokuBoard copy = new SudokuBoard();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int value = original.getElement(r, c).getValue();
                copy.getElement(r, c).setValue(value);
            }
        }
        return copy;
    }

    private void copyToOriginal(SudokuBoard source, SudokuBoard target) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int value = source.getElement(r, c).getValue();
                target.getElement(r, c).setValue(value);
            }
        }
    }
}
