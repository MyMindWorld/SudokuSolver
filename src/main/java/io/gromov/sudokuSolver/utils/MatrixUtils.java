package io.gromov.sudokuSolver.utils;

import org.springframework.stereotype.Component;

@Component
public class MatrixUtils {
    public <T> T[][] deepCopy(T[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
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
