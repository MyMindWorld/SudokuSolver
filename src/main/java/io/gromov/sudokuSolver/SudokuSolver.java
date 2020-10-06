package io.gromov.sudokuSolver;

import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Predicate;

@Log
@Service
public class SudokuSolver {
    @EventListener(ApplicationStartedEvent.class)
    public void EntryMethod() {
        isBoardNumbersValid(invalidBoard);
        isBoardInCorrectState(invalidBoard);
    }

    private Integer blockSum = 45;


    Integer[][] invalidBoard = {
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0},
            {9, 7, 5, 2, 1, 5, 0, 0, 0}
    };


    public Boolean isBoardNumbersValid(Integer[][] board) {
        Predicate<Integer> sudokuValidNumbers = i -> i >= 0 & i <= 9;
        Boolean numbersValid = Arrays.stream(board).allMatch(ints -> Arrays.stream(ints).allMatch(sudokuValidNumbers));
        log.info("Numbers valid : " + numbersValid);
        return numbersValid;
    }


    public Boolean isBoardInCorrectState(Integer[][] board) {
        Boolean horizontallyValid = Arrays.stream(board).allMatch(ints -> blockSum <= Arrays.stream(ints).reduce(0, Integer::sum));

        Boolean verticallyValid = true;
        for (int horizontalIterator = 0; board.length > horizontalIterator; horizontalIterator++) {
            Integer verticalSum = 0;
            for (int verticalIterator = 0; board.length > verticalIterator; verticalIterator++) {
                verticalSum += board[horizontalIterator][verticalIterator];
            }
            log.info(String.valueOf(verticalSum));
            if (verticalSum > 0 & verticalSum < blockSum) {
                verticallyValid = false;
                break;
            }

        }


        Integer boxSums[][] = new Integer[3][3];
        for (int horizontalIterator = 0; board.length > horizontalIterator; horizontalIterator += 1) {
            for (int verticalIterator = 0; board.length > verticalIterator; verticalIterator += 1) {
                if (boxSums[horizontalIterator / 3][verticalIterator / 3] == null) {
                    boxSums[horizontalIterator / 3][verticalIterator / 3] = 0;
                }
                boxSums[horizontalIterator / 3][verticalIterator / 3] += board[horizontalIterator][verticalIterator];
            }
        }
        printMatrix(boxSums);
        Boolean gridValid = Arrays.stream(boxSums).allMatch(integers -> blockSum <= Arrays.stream(integers).reduce(0, Integer::sum));


        log.info("Horizontally valid : " + horizontallyValid);
        log.info("Vertically valid : " + verticallyValid);
        log.info("Grid's valid : " + gridValid);

        if (!horizontallyValid || !gridValid) {
            return false;
        }
        return true;
    }

    public void printMatrix(Integer[][] matrix) {
        for (int row = 0; row < matrix.length; row++)//Cycles through rows
        {
            for (int col = 0; col < matrix[row].length; col++)//Cycles through columns
            {
                System.out.printf("%5d", matrix[row][col]); //change the %5d to however much space you want
            }
            System.out.println(); //Makes a new row
        }
    }

}
