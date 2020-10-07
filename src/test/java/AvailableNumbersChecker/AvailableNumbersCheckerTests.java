package AvailableNumbersChecker;

import io.gromov.sudokuSolver.SudokuSolver;
import io.gromov.sudokuSolver.service.AvailableNumbersChecker;
import io.gromov.sudokuSolver.service.ValidityChecker;
import io.gromov.sudokuSolver.utils.MatrixUtils;
import io.gromov.sudokuSolver.utils.TestBoards;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Log
@Test
@ContextConfiguration
@SpringBootTest(classes = {SudokuSolver.class, TestBoards.class})
public class AvailableNumbersCheckerTests extends AbstractTestNGSpringContextTests {
    @Autowired
    AvailableNumbersChecker availableNumbersChecker;
    @Autowired
    TestBoards testBoards;
    @Autowired
    ValidityChecker validityChecker;
    @Autowired
    MatrixUtils matrixUtils;

    @Test
    public void availableNumbersCheckerReturningAllPossibleNumbers() {
        Integer[][] oneNumberUnfilledBoard = {
                {4, 2, 9, 8, 1, 3, 5, 0, 0},
                {5, 1, 6, 4, 7, 2, 9, 8, 8},
                {7, 8, 3, 6, 5, 9, 2, 4, 1},
                {6, 7, 2, 1, 3, 4, 8, 5, 9},
                {3, 9, 5, 2, 8, 6, 1, 7, 4},
                {8, 4, 1, 7, 9, 5, 6, 2, 3},
                {1, 5, 8, 3, 6, 7, 4, 9, 2},
                {9, 3, 4, 5, 2, 8, 7, 1, 0},
                {2, 6, 7, 9, 4, 1, 3, 8, 5}};
        Integer rowPos = 0;
        Integer colPos = 8;


        List<Integer> possibleNumbersForBoard = Arrays.asList(6, 7);
        List<Integer> numbersCheckerResult = availableNumbersChecker.getPossibleNumbersForPlace(oneNumberUnfilledBoard, rowPos, colPos);

        Assert.assertEquals(numbersCheckerResult, possibleNumbersForBoard);
    }

    @Test
    public void availableNumbersCheckerReturningAllPossibleNumbersForEveryPlaceInBoard() {
        for (int row = 0; testBoards.validBoard.length > row; row++) {
            for (int col = 0; testBoards.validBoard.length > col; col++) {
                Integer[][] boardWithMissingNumber = testBoards.validBoard.clone();
                Integer validNumber = testBoards.validBoard[row][col];
                Integer rowPos = row;
                Integer colPos = col;
                boardWithMissingNumber[row][col] = 0;
                List<Integer> possibleNumbersForBoard = Arrays.asList(validNumber);
                List<Integer> numbersCheckerResult = availableNumbersChecker.getPossibleNumbersForPlace(boardWithMissingNumber, rowPos, colPos);
                matrixUtils.printMatrix(boardWithMissingNumber);
                logger.info("Expecting number : " + validNumber);
                Assert.assertEquals(numbersCheckerResult, possibleNumbersForBoard);
                boardWithMissingNumber[row][col] = validNumber;
                logger.info("Passed");
            }
        }
    }
}
