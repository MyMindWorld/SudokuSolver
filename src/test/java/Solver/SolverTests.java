package Solver;

import io.gromov.sudokuSolver.SudokuSolver;
import io.gromov.sudokuSolver.service.AvailableNumbersChecker;
import io.gromov.sudokuSolver.service.Solver;
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

@Log
@Test
@ContextConfiguration
@SpringBootTest(classes = {SudokuSolver.class, TestBoards.class})
public class SolverTests extends AbstractTestNGSpringContextTests {
    @Autowired
    AvailableNumbersChecker availableNumbersChecker;
    @Autowired
    TestBoards testBoards;
    @Autowired
    ValidityChecker validityChecker;
    @Autowired
    MatrixUtils matrixUtils;
    @Autowired
    Solver solver;

    @Test
    public void testSolveBackTrackAlgorithmWithEasyBoard() {
        Integer[][] boardToSolve = matrixUtils.deepCopy(testBoards.unsolvedValidEasyBoard);
        solver.solveBoard(boardToSolve);
        matrixUtils.printMatrix(boardToSolve);
        Assert.assertTrue(validityChecker.isBoardSolved(boardToSolve));
    }

    @Test
    public void testSolveBackTrackAlgorithmWithHardBoard() {
        Integer[][] boardToSolve = matrixUtils.deepCopy(testBoards.unsolvedValidHardBoard);
        solver.solveBoard(boardToSolve);
        matrixUtils.printMatrix(boardToSolve);
        Assert.assertTrue(validityChecker.isBoardSolved(boardToSolve));
    }

    @Test
    public void testSolveBackTrackAlgorithmWithExpertBoard() {
        Integer[][] boardToSolve = matrixUtils.deepCopy(testBoards.unsolvedValidExpertBoard);
        solver.solveBoard(boardToSolve);
        matrixUtils.printMatrix(boardToSolve);
        Assert.assertTrue(validityChecker.isBoardSolved(boardToSolve));
    }

    @Test
    public void testSolveBackTrackAlgorithmWithInsaneBoard() {
        Integer[][] boardToSolve = matrixUtils.deepCopy(testBoards.unsolvedValidInsaneBoard);
        solver.solveBoard(boardToSolve);
        matrixUtils.printMatrix(boardToSolve);
        Assert.assertTrue(validityChecker.isBoardSolved(boardToSolve));
    }

}