package io.gromov.sudokuSolver.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.gromov.sudokuSolver.utils.Constants.possibleNumbers;

@Log
@Service
public class AvailableNumbersChecker {

    public List<Integer> getPossibleNumbersForPlace(Integer[][] board, Integer rowPos, Integer colPos) {
        List<Integer> remainingPossibleNumbers = new ArrayList<>();
        remainingPossibleNumbers.addAll(Arrays.asList(possibleNumbers));
        // Removing all filled row numbers
        for (int columnIndex = 0; board.length > columnIndex; columnIndex++) {
            remainingPossibleNumbers.remove(Integer.valueOf(board[rowPos][columnIndex]));
        }
        // Removing all filled col numbers
        for (int rowIndex = 0; board.length > rowIndex; rowIndex++) {
            remainingPossibleNumbers.remove(Integer.valueOf(board[rowIndex][colPos]));
        }
        // Removing all filled grid numbers
        for (int row = 3 * (rowPos / 3); 3 * (rowPos / 3) + 3 > row; row++) {
            for (int col = 3 * (colPos / 3); 3 * (colPos / 3) + 3 > col; col++) {
                remainingPossibleNumbers.remove(Integer.valueOf(board[row][col]));
            }
        }

        return remainingPossibleNumbers;
    }

}
