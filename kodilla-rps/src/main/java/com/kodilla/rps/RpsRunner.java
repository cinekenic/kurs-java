package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean endGame = false;

        while (!endGame) {
            String playerName = getPlayerName(scanner);
            int roundsToWin = getRoundsToWin(scanner);
            playGame(scanner, playerName, roundsToWin);

            System.out.println("Czy chcesz zakończyć grę? (t/n)");

            if (scanner.nextLine().equals("t")) {
                endGame = true;
            }

        }

        System.out.println("Dziękujemy za grę!");
        scanner.close();

    }

        private static String getPlayerName(Scanner scanner){
            System.out.println("Podaj swoje imię:");
            return scanner.nextLine();
        }

         private static int getRoundsToWin(Scanner scanner){
            System.out.println("Podaj liczbę wygranych rund do zwycięstwa:");
            int rounds = scanner.nextInt();
            scanner.nextLine();
            return rounds;
        }

    private static void playGame(Scanner scanner, String playerName, int roundsToWin){

            Random random = new Random();

            int playerWins = 0;
            int computerWins = 0;

            System.out.println("Klawisze do obsługi gry:");
            System.out.println("1 – Kamień");
            System.out.println("2 – Papier");
            System.out.println("3 – Nożyce");
            System.out.println("x – Zakończ grę");
            System.out.println("n – Nowa gra");

            boolean roundActive = true;


            while (roundActive) {
                String playerMove = getPlayerMove(scanner);

                if(playerMove.equals("x")) {
                    if (confirmAction(scanner, "Czy na pewno zakończyć grę? (t/n)")){
                    return;
                    }
                    continue;
                }

                if(playerMove.equals("n")) {
                    if (confirmAction(scanner, "Czy na pewno zakończyć aktualną grę? (t/n)")) {
                        return;
                    }
                    continue;
                }

                int playerChoice = parsePlayerChoice(playerMove);
                if(playerChoice == -1) {
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                    continue;
                }

                int computerChoice = random.nextInt(3) + 1;

                System.out.println(playerName + " wybrał: " + moveName(playerChoice));
                System.out.println("Komputer wybrał: " + moveName(computerChoice));

                int result = checkWinner(playerChoice, computerChoice);

                if(result == 1) {
                    System.out.println("Wygrałeś rundę!");
                    playerWins++;
                }else if(result == -1) {
                    System.out.println("Komputer wygrał rundę!");
                    computerWins++;
                }else {
                    System.out.println("Remis!");
                }

                System.out.println("Wynik: " + playerName + " " + playerWins + " - " + computerWins + " Komputer");

                if(playerWins == roundsToWin) {
                    System.out.println("Gratulacje! Wygrałeś grę!");
                    roundActive = false;
                } else if (computerWins == roundsToWin) {
                    System.out.println("Komputer wygrał grę. Spróbuj ponownie!");
                    roundActive = false;
                }
            }
    }



private static String getPlayerMove(Scanner scanner){
    System.out.println("Wybierz swój ruch: (1-Kamień, 2-Papier, 3-Nożyce)");
    return scanner.nextLine();
}

private static boolean confirmAction(Scanner scanner, String message){
    System.out.println(message);
    return scanner.nextLine().equals("t");
}


private static int parsePlayerChoice(String playerMove){
        try {
            int choice = Integer.parseInt(playerMove);
            if(choice < 1 || choice > 3) {
                return -1;
            }
            return choice;
        }catch(NumberFormatException e) {
            return -1;
        }
}

private static String moveName(int move) {
        return switch (move){
            case 1 -> "Kamień";
            case 2 -> "Papier";
            case 3 -> "Nożyce";
            default -> "Nieznany";
        };
    }

    private static int checkWinner(int playerMove, int computerMove) {
        if (playerMove == computerMove){
            return 0;
        }else if ((playerMove == 1 && computerMove == 3) ||
                  (playerMove == 2 && computerMove == 1) ||
                  (playerMove == 3 && computerMove == 2)) {
            return 1;
        } else {
            return -1;
        }
    }
}
