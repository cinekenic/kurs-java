package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private final Set<Integer> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
        }
    }

    public boolean isEmpty() {
        return value == EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        if (value != EMPTY) {
            possibleValues.clear();
        }
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void removePossibleValue(int val) {
        possibleValues.remove(val);
    }

    public boolean hasOnlyOnePossibleValue() {
        return possibleValues.size() == 1;
    }

    public int getSinglePossibleValue() {
        return possibleValues.iterator().next();
    }

    @Override
    public String toString() {
        return isEmpty() ? "." : String.valueOf(value);
    }
}
