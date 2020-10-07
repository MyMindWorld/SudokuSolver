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
public class ValidityCheckerNegativeTests extends AbstractTestNGSpringContextTests {
    @Autowired
    ValidityChecker validityChecker;
    @Autowired
    TestBoards testBoards;

    @Test
    public void invalidBoardNotPassingNumbersCheck() {
        Assert.assertFalse(validityChecker.isBoardNumbersValid(testBoards.completelyInvalidBoard));
    }

    @Test
    public void invalidBoardNotPassingStateCheck() {
        Assert.assertFalse(validityChecker.isBoardInCorrectState(testBoards.completelyInvalidBoard));
    }

    @Test
    public void rowInvalidBoardNotPassingRowsCheck() {
        Assert.assertFalse(validityChecker.isBoardRowsValid(testBoards.rowAndGridInvalidBoard));
    }

    @Test
    public void columnInvalidBoardNotPassingColumnsCheck() {
        Assert.assertFalse(validityChecker.isBoardColumnsValid(testBoards.columnAndGridInvalidBoard));
    }

    @Test
    public void gridInvalidBoardNotPassingGridSumsCheck() {
        Assert.assertFalse(validityChecker.isBoardGridsSumsValid(testBoards.columnAndGridInvalidBoard));
    }

    @Test
    public void gridInvalidBoardNotPassingGridCheck() {
        Assert.assertFalse(validityChecker.isBoardGridsValid(testBoards.oneGridIncorrectlyFilledBoard));
    }

    @Test
    public void unsolvedBoardNotPassingSolvedCheck() {
        Assert.assertFalse(validityChecker.isBoardSolved(testBoards.incorrectlyGridSolvedBoard));
    }

    @Test
    public void incorrectlySolvedBoardNotPassingSolvedCheck() {
        Assert.assertFalse(validityChecker.isBoardSolved(testBoards.completelyInvalidBoard));
    }
}
