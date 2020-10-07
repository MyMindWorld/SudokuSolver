package io.gromov.sudokuSolver.utils;

import org.springframework.stereotype.Component;

@Component
public class TestBoards {
    public Integer[][] completelyInvalidBoard = {
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

    public Integer[][] validBoard = {
            {4, 2, 9, 8, 1, 3, 5, 6, 7},
            {5, 1, 6, 4, 7, 2, 9, 3, 8},
            {7, 8, 3, 6, 5, 9, 2, 4, 1},
            {6, 7, 2, 1, 3, 4, 8, 5, 9},
            {3, 9, 5, 2, 8, 6, 1, 7, 4},
            {8, 4, 1, 7, 9, 5, 6, 2, 3},
            {1, 5, 8, 3, 6, 7, 4, 9, 2},
            {9, 3, 4, 5, 2, 8, 7, 1, 6},
            {2, 6, 7, 9, 4, 1, 3, 8, 5}};

    public Integer[][] rowAndGridInvalidBoard = {
            {4, 2, 9, 8, 1, 3, 5, 6, 8},
            {5, 1, 6, 4, 7, 2, 9, 3, 8},
            {7, 8, 3, 6, 5, 9, 2, 4, 1},
            {6, 7, 2, 1, 3, 4, 8, 5, 9},
            {3, 9, 5, 2, 8, 6, 1, 7, 4},
            {8, 4, 1, 7, 9, 5, 6, 2, 3},
            {1, 5, 8, 3, 6, 7, 4, 9, 2},
            {9, 3, 4, 5, 2, 8, 7, 1, 6},
            {2, 6, 7, 9, 4, 1, 3, 8, 5}};

    public Integer[][] incorrectlyGridSolvedBoard = {
            {4, 2, 9, 8, 1, 3, 5, 6, 7},
            {5, 1, 6, 4, 7, 2, 9, 3, 8},
            {7, 8, 3, 6, 5, 9, 2, 4, 1},
            {6, 7, 2, 1, 3, 4, 8, 5, 9},
            {3, 9, 5, 2, 8, 6, 1, 7, 4},
            {8, 4, 1, 7, 9, 5, 6, 2, 3},
            {1, 5, 8, 3, 6, 7, 5, 9, 2},
            {9, 3, 4, 5, 2, 8, 6, 1, 6},
            {2, 6, 7, 9, 4, 1, 3, 8, 5}};

    public Integer[][] columnAndGridInvalidBoard = {
            {4, 2, 9, 8, 1, 3, 5, 6, 7},
            {5, 1, 6, 4, 7, 2, 9, 8, 8},
            {7, 8, 3, 6, 5, 9, 2, 4, 1},
            {6, 7, 2, 1, 3, 4, 8, 5, 9},
            {3, 9, 5, 2, 8, 6, 1, 7, 4},
            {8, 4, 1, 7, 9, 5, 6, 2, 3},
            {1, 5, 8, 3, 6, 7, 4, 9, 2},
            {9, 3, 4, 5, 2, 8, 7, 1, 6},
            {2, 6, 7, 9, 4, 1, 3, 8, 5}};

    public Integer[][] oneGridIncorrectlyFilledBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 5, 5, 5},
            {0, 0, 0, 0, 0, 0, 5, 5, 5},
            {0, 0, 0, 0, 0, 0, 5, 5, 5}};

    public Integer[][] oneGridCorrectlyFilledBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 3},
            {0, 0, 0, 0, 0, 0, 4, 5, 6},
            {0, 0, 0, 0, 0, 0, 7, 8, 9}};


//    ---- Unsolved valid boards

    public Integer[][] unsolvedValidEasyBoard = {
            {1, 5, 0, 0, 0, 4, 0, 0, 7},
            {2, 0, 9, 8, 7, 0, 3, 0, 5},
            {0, 0, 7, 0, 3, 5, 0, 0, 9},
            {5, 8, 4, 0, 1, 0, 2, 7, 6},
            {0, 0, 0, 0, 0, 2, 0, 0, 3},
            {0, 0, 1, 4, 6, 7, 0, 5, 0},
            {0, 0, 2, 0, 5, 8, 6, 0, 1},
            {0, 1, 5, 3, 0, 9, 7, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 3, 0}};

    public Integer[][] unsolvedValidHardBoard = {
            {0, 0, 0, 0, 5, 0, 0, 0, 0},
            {6, 1, 5, 9, 0, 0, 8, 7, 0},
            {4, 0, 0, 3, 0, 0, 2, 0, 5},
            {1, 0, 0, 5, 7, 0, 3, 0, 0},
            {0, 2, 0, 8, 0, 3, 0, 5, 0},
            {8, 0, 0, 0, 0, 0, 0, 0, 9},
            {0, 0, 6, 1, 0, 9, 0, 0, 7},
            {0, 9, 8, 0, 0, 7, 4, 0, 1},
            {0, 0, 0, 0, 8, 0, 0, 0, 0}};


    public Integer[][] unsolvedValidInsaneBoard = {
            {0, 2, 0, 0, 0, 0, 0, 9, 0},
            {4, 0, 0, 9, 7, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 0},
            {0, 0, 9, 0, 1, 7, 2, 0, 4},
            {0, 8, 0, 0, 6, 0, 7, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 1, 0, 0, 2},
            {0, 7, 0, 2, 0, 0, 9, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0}};

    public Integer[][] unsolvedValidExpertBoard = {
            {0, 0, 0, 0, 0, 1, 3, 0, 0},
            {7, 6, 0, 4, 0, 0, 1, 0, 0},
            {0, 0, 5, 0, 7, 0, 0, 6, 0},
            {6, 0, 0, 0, 0, 0, 0, 3, 0},
            {0, 0, 0, 0, 0, 7, 0, 4, 9},
            {5, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 2, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 8, 4, 0, 0, 0, 0, 0, 0}};


}
