package com.rpsgame.strategy;

import com.rpsgame.model.Move;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class HardStrategy implements Strategy {

    private Random random = new Random();

    @Override
    public Move getComputerMove(List<Move> playerHistory) {

        if (playerHistory.isEmpty()) {
            return getRandomMove();
        }

        Move predictedPlayerMove = predictBasedOnLastMove(playerHistory);

        if (predictedPlayerMove != null) {
            return getCounterMove(predictedPlayerMove);
        }

        predictedPlayerMove = findMostFrequentOverall(playerHistory);
        return getCounterMove(predictedPlayerMove);
    }

    private Move predictBasedOnLastMove(List<Move> playerHistory) {
        if (playerHistory.size() < 2) {
            return null;
        }

        Move lastMove = playerHistory.get(playerHistory.size() - 1);

        Map<Move, Integer> nextMoveCounts = new HashMap<>();

        for (int i = 0; i < playerHistory.size() - 1; i++) {
            if (playerHistory.get(i) == lastMove) {
                Move nextMove = playerHistory.get(i + 1);
                nextMoveCounts.put(nextMove, nextMoveCounts.getOrDefault(nextMove, 0) + 1);
            }
        }

        if (nextMoveCounts.isEmpty()) {
            return null;
        }

        Move mostFrequentNextMove = null;
        int maxCount = -1;

        for (Map.Entry<Move, Integer> entry : nextMoveCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentNextMove = entry.getKey();
            }
        }
        return mostFrequentNextMove;
    }

    private Move findMostFrequentOverall(List<Move> playerHistory) {
        Map<Move, Integer> moveCounts = new HashMap<>();
        moveCounts.put(Move.ROCK, 0);
        moveCounts.put(Move.PAPER, 0);
        moveCounts.put(Move.SCISSORS, 0);

        for (Move move : playerHistory) {
            moveCounts.put(move, moveCounts.get(move) + 1);
        }

        Move mostFrequentMove = Move.ROCK;
        int maxCount = -1;

        for (Map.Entry<Move, Integer> entry : moveCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentMove = entry.getKey();
            }
        }
        return mostFrequentMove;
    }

    private Move getCounterMove(Move move) {
        if (move == null) {
            return getRandomMove();
        }

        switch (move) {
            case ROCK:
                return Move.PAPER;
            case PAPER:
                return Move.SCISSORS;
            case SCISSORS:
                return Move.ROCK;
            default:
                return getRandomMove();
        }
    }

    private Move getRandomMove() {
        Move[] allMoves = Move.values();
        int randomIndex = random.nextInt(allMoves.length);
        return allMoves[randomIndex];
    }
}