package io.gromov.sudokuSolver.utils;

import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static final Integer blockSum = 45;
    public static final Integer EMPTY = 0;
    public static final Integer[] possibleNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
}
