package ValidityChecker;

import io.gromov.sudokuSolver.SudokuSolver;
import io.gromov.sudokuSolver.service.ValidityChecker;
import io.gromov.sudokuSolver.utils.TestBoards;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
@Test
@ContextConfiguration
@SpringBootTest(classes = {SudokuSolver.class})
public class ValidityCheckerPositiveTests extends AbstractTestNGSpringContextTests {
    @Autowired
    ValidityChecker validityChecker;
    @Autowired
    TestBoards testBoards;

    @Test
    public void validBoardPassingNumbersCheck() {
        Assert.assertTrue(validityChecker.isBoardNumbersValid(testBoards.validBoard));
    }

    @Test
    public void rowValidBoardPassingRowCheck() {
        Assert.assertTrue(validityChecker.isBoardRowsValid(testBoards.validBoard));
    }

    @Test
    public void columnValidBoardPassingColumnCheck() {
        Assert.assertTrue(validityChecker.isBoardColumnsValid(testBoards.validBoard));
    }

    @Test
    public void gridValidBoardPassingGridCheck() {
        Assert.assertTrue(validityChecker.isBoardGridsValid(testBoards.oneGridCorrectlyFilledBoard));
    }

    @Test
    public void gridValidBoardPassingGridSumsCheck() {
        Assert.assertTrue(validityChecker.isBoardGridsValid(testBoards.validBoard));
    }

    @Test
    public void validBoardPassingStateCheck() {
        Assert.assertTrue(validityChecker.isBoardInCorrectState(testBoards.validBoard));
    }

    @Test
    public void solvedBoardPassingSolvedCheck() {
        Assert.assertTrue(validityChecker.isBoardSolved(testBoards.validBoard));
    }
}
