package com.rpsgame.strategy;

import com.rpsgame.model.Move;
import java.util.List;


public interface Strategy {
    Move getComputerMove(List<Move> playerHistory);
}