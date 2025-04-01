package com.kodilla.sudoku;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuSolver;


import java.util.Scanner;

public class SudokuGame {

    private final Scanner scanner = new Scanner(System.in);

    public boolean resolveSudoku() {
        SudokuBoard board = new SudokuBoard();
        System.out.println("Pusta plansza:");
        System.out.println(board);

        while (true) {
            System.out.print("Podaj współrzędne i wartość (np. 2,3,9), lub SUDOKU by rozwiązać: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("SUDOKU")) {
                SudokuSolver solver = new SudokuSolver();
                boolean solved = solver.solve(board);

                if (solved) {
                    System.out.println("Rozwiązanie Sudoku:");
                    System.out.println(board);
                } else {
                    System.out.println("Nie udało się rozwiązać Sudoku.");
                }

                System.out.print("\nWciśnij ENTER, aby zacząć od nowa, lub wpisz 'X', by zakończyć: ");
                String next = scanner.nextLine().trim().toUpperCase();
                return next.equals("X");
            }

            try {
                String[] parts = input.split(",");
                int col = Integer.parseInt(parts[0]) - 1;
                int row = Integer.parseInt(parts[1]) - 1;
                int value = Integer.parseInt(parts[2]);

                if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
                    if (board.isValidPlacement(row, col, value)) {
                        board.getElement(row, col).setValue(value);
                        System.out.println(board);
                    } else {
                        System.out.println("❌ Nieprawidłowe dane – ta wartość już istnieje w wierszu, kolumnie lub bloku!");
                    }

                } else {
                    System.out.println("Nieprawidłowe dane wejściowe.");
                }
            } catch (Exception e) {
                System.out.println("Błąd formatu! Spróbuj ponownie.");
            }
        }
    }
}