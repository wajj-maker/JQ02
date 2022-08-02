package day11;

public class Solution07 {

}

class NumMatrix {
    private int[][] matrix;
    private int[][] helpMatrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        helpMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < helpMatrix.length; i++) {
            int temp = 0;
            for (int j = 0; j < helpMatrix[0].length; j++) {
                temp += matrix[i][j];
                if (i == 0) {
                    helpMatrix[i][j] = temp;
                } else {
                    helpMatrix[i][j] = temp + helpMatrix[i - 1][j];
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return helpMatrix[row2][col2];
        } else if (row1 == 0) {
            return helpMatrix[row2][col2] - helpMatrix[row2][col1 - 1];
        } else if (col1 == 0) {
            return helpMatrix[row2][col2] - helpMatrix[row1 - 1][col2];
        } else {
            return helpMatrix[row2][col2] - helpMatrix[row1 - 1][col2] - helpMatrix[row2][col1 - 1] + helpMatrix[row1 - 1][col1 - 1];
        }
    }
}
