package com.rpsgame;

import com.rpsgame.model.Move;
import com.rpsgame.strategy.Strategy;
import com.rpsgame.strategy.EasyStrategy;
import com.rpsgame.strategy.MediumStrategy;
import com.rpsgame.strategy.HardStrategy;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Game {

    private Strategy currentStrategy;
    private Scanner scanner;
    private List<Move> playerHistory;
    private int playerWins;
    private int computerWins;
    private int draws;

    public Game() {
        scanner = new Scanner(System.in);
        playerHistory = new ArrayList<>();
        playerWins = 0;
        computerWins = 0;
        draws = 0;
    }

    public void start() {
        selectDifficulty();

        System.out.println("Game started! Type 'exit' to quit.");
        System.out.println("----------------------------------------");

        while (true) {
            Move playerMove = getPlayerMove();

            if (playerMove == null) {
                break;
            }

            Move computerMove = currentStrategy.getComputerMove(playerHistory);

            determineWinner(playerMove, computerMove);

            playerHistory.add(playerMove);
        }

        printFinalResults();
        scanner.close();
    }

    private void selectDifficulty() {
        System.out.println("Select difficulty level:");
        System.out.println("1 - Easy ");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    currentStrategy = new EasyStrategy();
                    return;
                case "2":
                    currentStrategy = new MediumStrategy();
                    return;
                case "3":
                    currentStrategy = new HardStrategy();
                    return;
                default:
                    System.out.println("Error: please enter 1, 2, or 3.");
            }
        }
    }

    private Move getPlayerMove() {
        System.out.print("Your move (1 - Rock, 2 - Scissors, 3 - Paper) or 'exit': ");
        while (true) {
            String input = scanner.nextLine().toLowerCase().trim();

            switch (input) {
                case "1":
                case "rock":
                case "r":
                    return Move.ROCK;
                case "2":
                case "scissors":
                case "s":
                    return Move.SCISSORS;
                case "3":
                case "paper":
                case "p":
                    return Move.PAPER;
                case "exit":
                    return null;
                default:
                    System.out.print("Invalid move. Try again (1, 2, 3 or 'exit'): ");
            }
        }
    }

    private void determineWinner(Move playerMove, Move computerMove) {
        System.out.println("Your move: " + playerMove);
        System.out.println("Computer's move: " + computerMove);

        if (playerMove == computerMove) {
            System.out.println("Result: It's a draw!");
            draws++;
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                (playerMove == Move.SCISSORS && computerMove == Move.PAPER) ||
                (playerMove == Move.PAPER && computerMove == Move.ROCK)) {
            System.out.println("Result: You win!");
            playerWins++;
        } else {
            System.out.println("Result: Computer wins!");
            computerWins++;
        }
        System.out.println("----------------------------------------");
    }

    private void printFinalResults() {
        System.out.println("\n===== FINAL RESULTS =====");
        System.out.println("Player wins: " + playerWins);
        System.out.println("Computer wins: " + computerWins);
        System.out.println("Draws: " + draws);
        System.out.println("Thanks for playing!");
    }
}