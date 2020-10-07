package io.gromov.sudokuSolver.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static io.gromov.sudokuSolver.utils.Constants.EMPTY;
import static io.gromov.sudokuSolver.utils.Constants.blockSum;

@Log
@Service
public class ValidityChecker {


    public Boolean isBoardNumbersValid(Integer[][] board) {
        Predicate<Integer> sudokuValidNumbersPredicate = i -> i >= 0 & i <= 9;
        return Arrays.stream(board).allMatch(ints -> Arrays.stream(ints).allMatch(sudokuValidNumbersPredicate));
    }

    public Boolean isBoardRowsValid(Integer[][] board) {
        return Arrays.stream(board).allMatch(ints -> blockSum >= Arrays.stream(ints).reduce(0, Integer::sum));
    }

    public Boolean isBoardColumnsValid(Integer[][] board) {
        for (int row = 0; board.length > row; row++) {
            Integer columnsSum = 0;
            for (int col = 0; board.length > col; col++) {
                columnsSum += board[row][col];
            }
            if (columnsSum < 0 || columnsSum > blockSum) {
                return false;
            }

        }
        return true;
    }

    public Boolean isBoardGridsSumsValid(Integer[][] board) {
        Integer[][] boxSums = getBoxSums(board);

        Boolean gridValid = Arrays.stream(boxSums).allMatch(
                integers -> Arrays.stream(integers).allMatch(
                        integer -> blockSum >= integer
                ));
        return gridValid;
    }

    public Boolean isBoardGridsValid(Integer[][] board) {
        for (int gridRowIndex = 0; board.length > gridRowIndex; gridRowIndex += 3) {
            for (int gridColIndex = 0; board.length > gridColIndex; gridColIndex += 3) {
                List<Integer> gridFilledNumbers = new ArrayList<>();
                for (Integer i : gridFilledNumbers) {
                    log.info(String.valueOf(i));
                }
                for (int row = 3 * (gridRowIndex / 3); 3 * (gridRowIndex / 3) + 3 > row; row++) {
                    for (int col = 3 * (gridColIndex / 3); 3 * (gridColIndex / 3) + 3 > col; col++) {
                        if (board[row][col] == EMPTY) {
                            continue;
                        }
                        if (gridFilledNumbers.contains(Integer.valueOf(board[row][col]))) {
                            log.info("INVALID! Error on : " + row + "_" + col + ". Repeating number : " + board[row][col]);
                            return false;
                        } else {
                            gridFilledNumbers.add(Integer.valueOf(board[row][col]));
                        }
                    }
                }

            }
        }
        return true;
    }


    public Boolean isBoardInCorrectState(Integer[][] board) {
        Boolean numbersValid = isBoardNumbersValid(board);

        Boolean rowValid = isBoardRowsValid(board);

        Boolean columnValid = isBoardColumnsValid(board);

        Boolean gridValid = isBoardGridsValid(board);

        Boolean gridSumsValid = isBoardGridsSumsValid(board);

        return columnValid && rowValid && gridValid && numbersValid && gridSumsValid;
    }

    public boolean isBoardSolved(Integer[][] board) {
        return isBoardInCorrectState(board) & isBoardGridSolved(board);
    }

    public boolean isBoardGridSolved(Integer[][] board) {
        Integer[][] boxSums = getBoxSums(board);
        for (int row = 0; row < boxSums.length; row++) {
            for (int col = 0; col < boxSums[row].length; col++) {
                if (boxSums[col][row] != blockSum) {
                    return false;
                }
            }
        }
        return true;
    }

    public Integer[][] getBoxSums(Integer[][] board) {
        Integer[][] boxSums = new Integer[3][3];
        for (Integer[] row : boxSums) {
            Arrays.fill(row, EMPTY);
        }

        for (int row = 0; board.length > row; row++) {
            for (int col = 0; board.length > col; col++) {
                boxSums[row / 3][col / 3] += board[row][col];
            }
        }
        return boxSums;
    }


}
