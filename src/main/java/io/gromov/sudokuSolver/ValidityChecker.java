package io.gromov.sudokuSolver;

import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Predicate;

@Log
@Service
public class ValidityChecker {
    @EventListener(ApplicationStartedEvent.class)
    public void EntryMethod() {
        log.info("Invalid board:");
        printMatrix(getBoxSums(completelyInvalidBoard));
        isBoardNumbersValid(completelyInvalidBoard);
        isBoardInCorrectState(completelyInvalidBoard);
        isSolved(completelyInvalidBoard);

        log.info("---------------\n");

        log.info("Valid board:");
        printMatrix(getBoxSums(validBoard));
        isBoardNumbersValid(validBoard);
        isBoardInCorrectState(validBoard);
        isSolved(validBoard);
    }

    private Integer blockSum = 45;


    Integer[][] completelyInvalidBoard = {
            {9, 7, 5, 2, 1, 5, 9, 9, 9},
            {9, 7, 5, 2, 1, 5, 0, 10, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0}
    };

    Integer[][] validBoard = {
            {4, 2, 9, 8, 1, 3, 5, 6, 7},
            {5, 1, 6, 4, 7, 2, 9, 3, 8},
            {7, 8, 3, 6, 5, 9, 2, 4, 1},
            {6, 7, 2, 1, 3, 4, 8, 5, 9},
            {3, 9, 5, 2, 8, 6, 1, 7, 4},
            {8, 4, 1, 7, 9, 5, 6, 2, 3},
            {1, 5, 8, 3, 6, 7, 4, 9, 2},
            {9, 3, 4, 5, 2, 8, 7, 1, 6},
            {2, 6, 7, 9, 4, 1, 3, 8, 5}};


    public Boolean isBoardNumbersValid(Integer[][] board) {
        Predicate<Integer> sudokuValidNumbers = i -> i >= 0 & i <= 9;
        Boolean numbersValid = Arrays.stream(board).allMatch(ints -> Arrays.stream(ints).allMatch(sudokuValidNumbers));
        log.info("Numbers valid : " + numbersValid);
        return numbersValid;
    }


    public Boolean isBoardInCorrectState(Integer[][] board) {
        Boolean horizontallyValid = Arrays.stream(board).allMatch(ints -> blockSum >= Arrays.stream(ints).reduce(0, Integer::sum));

        Boolean verticallyValid = true;
        for (int horizontalIterator = 0; board.length > horizontalIterator; horizontalIterator++) {
            Integer verticalSum = 0;
            for (int verticalIterator = 0; board.length > verticalIterator; verticalIterator++) {
                verticalSum += board[horizontalIterator][verticalIterator];
            }
            if (verticalSum > 0 & verticalSum < blockSum) {
                verticallyValid = false;
                break;
            }

        }

        Integer[][] boxSums = getBoxSums(board);

        Boolean gridValid = Arrays.stream(boxSums).allMatch(
                integers -> Arrays.stream(integers).allMatch(
                        integer -> blockSum >= integer
                ));


        log.info("Horizontally valid : " + horizontallyValid);
        log.info("Vertically valid : " + verticallyValid);
        log.info("Grid's valid : " + gridValid);

        return verticallyValid && horizontallyValid && gridValid;
    }

    public Integer[][] getBoxSums(Integer[][] board) {
        Integer[][] boxSums = new Integer[3][3];
        for (int horizontalIterator = 0; board.length > horizontalIterator; horizontalIterator += 1) {
            for (int verticalIterator = 0; board.length > verticalIterator; verticalIterator += 1) {
                if (boxSums[horizontalIterator / 3][verticalIterator / 3] == null) {
                    boxSums[horizontalIterator / 3][verticalIterator / 3] = 0;
                }
                boxSums[horizontalIterator / 3][verticalIterator / 3] += board[horizontalIterator][verticalIterator];
            }
        }
        return boxSums;
    }


    public boolean isSolved(Integer[][] board) {
        Integer[][] boxSums = getBoxSums(board);
        for (int row = 0; row < boxSums.length; row++) {
            for (int col = 0; col < boxSums[row].length; col++) {
                if (boxSums[col][row] != blockSum) {
                    log.info("Board is not solved!");
                    return false;
                }
            }
        }
        log.info("Board is solved!");
        return true;
    }

    public void printMatrix(Integer[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%5d", matrix[row][col]);
            }
            System.out.println();
        }
    }

}
