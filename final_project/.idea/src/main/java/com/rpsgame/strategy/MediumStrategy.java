package com.rpsgame.strategy;

import com.rpsgame.model.Move;
import java.util.List;
import java.util.Random;

public class MediumStrategy implements Strategy {

    private Random random = new Random();

    @Override
    public Move getComputerMove(List<Move> playerHistory) {

        Move[] allMoves = Move.values();

        int randomIndex = random.nextInt(allMoves.length);

        return allMoves[randomIndex];
    }
}