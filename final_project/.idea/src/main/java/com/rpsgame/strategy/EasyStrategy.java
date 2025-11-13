package com.rpsgame.strategy;

import com.rpsgame.model.Move;
import java.util.List;


public class EasyStrategy implements Strategy {

    @Override
    public Move getComputerMove(List<Move> playerHistory) {
        return Move.ROCK;
    }
}