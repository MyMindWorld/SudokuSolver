package io.gromov.sudokuSolver.service;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.gromov.sudokuSolver.utils.Constants.EMPTY;

@Log
@Component
public class Solver {
    @Autowired
    AvailableNumbersChecker availableNumbersChecker;
    @Autowired
    ValidityChecker validityChecker;

    @SneakyThrows
    public boolean solveBoard(Integer[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == EMPTY) {
                    for (Integer possibleNum : availableNumbersChecker.getPossibleNumbersForPlace(board, row, col)) {

                        board[row][col] = possibleNum;

                        if (solveBoard(board)) { // Entering recursion with placed possible number
                            validityChecker.isBoardSolved(board);
                            return true; // Board is solved, exiting recursively
                        } else {
                            board[row][col] = EMPTY; // Removing number because after all other placements we failed
                        }
                    }
                    return false; // All numbers are checked and we still not done. This means one of placements was invalid
                }
            }
        }
        return true; // All fields are checked and correctly placed with no empty places. Exiting recursively
    }


}
