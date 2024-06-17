package org.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Min Danil 17.06.2024
 */

@Component
@RequiredArgsConstructor
public class Service {
    private final Scanner scanner;

    public int [][] createMatrix() {
        System.out.print("Введите кол-во столбцов: ");
        int colum = scanner.nextInt();
        System.out.print("Введите кол-во строк: ");
        int rows = scanner.nextInt();
        int [][] matrix = new int[rows][colum];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public int[][] removeColumn(int[][] matrix) {
        System.out.print("Введите индекс столбца: ");
        int columnIndex = scanner.nextInt();
        int[][] newMatrix = new int[matrix.length][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, newJ = 0; j < matrix[i].length; j++) {
                if (j != columnIndex) {
                    newMatrix[i][newJ] = matrix[i][j];
                    newJ++;
                }
            }
        }
        return newMatrix;
    }

    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public int[][] removeMainDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Матрица не квадратная!");
            return matrix;
        }
        int n = matrix.length;
        for (int i = 0; i < n * n; i++) {
            int row = i / n;
            int col = i % n;
            if (row == col) {
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    public int[][] replaceColumn(int[][] matrix1, int[][] matrix2, int columnIndex) {
        if (columnIndex >= matrix1[0].length
                || columnIndex >= matrix2[0].length || columnIndex < 0) {
            System.out.println("Неверный индекс!");
            return matrix1;
        }
        int numRows = Math.min(matrix1.length, matrix2.length);
        for (int i = 0; i < numRows; i++) {
            matrix1[i][columnIndex] = matrix2[i][columnIndex];
        }
        return matrix1;
    }

    public int[][] searchElement(int[][] matrix, int searchValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % searchValue == 0) {
                    if (j + 1 < matrix[i].length && matrix[i][j + 1] % 2 == 0) {
                        Arrays.fill(matrix[i], 0);
                    } else if (i + 1 < matrix.length && matrix[i + 1][j] % 2 != 0) {
                        for (int k = 0; k < matrix.length; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        if (n == 1) {
            return matrix[0][0];
        }
        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += matrix[0][j] * Math.pow(-1, j) * calculateDeterminant(getMinor(matrix, j));
        }
        return determinant;
    }

    private int[][] getMinor(int[][] matrix, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                minor[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }
        return minor;
    }

    public int[][] multiMatrix(int[][] matrixFirst, int[][] matrixSecond) {
        int[][] resultMatrix = new int[0][];
        if (matrixSecond != null && matrixFirst != null) {
            if (matrixSecond[0].length == matrixFirst.length) {
                resultMatrix = multiplyMatrices(matrixSecond, matrixFirst);
                System.out.println("Результат умножения матриц:");
            } else {
                System.out.println("Невозможно выполнить умножение. Количество столбцов первой матрицы не соответствует количеству строк второй матрицы.");
            }
        } else {
            System.out.println("Ошибка чтения матриц из файла или с клавиатуры.");
        }
        return resultMatrix;
    }

    private int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = secondMatrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }


    public int[][] swapRowsMatrix(int[][] matrix) {
        System.out.print("Введите номер первой строки для обмена: ");
        int firstRow = scanner.nextInt();
        System.out.print("Введите номер второй строки для обмена: ");
        int secondRow = scanner.nextInt();
        if (firstRow >= 0 && firstRow < matrix.length && secondRow >= 0 && secondRow < matrix.length) {
            swapRows(matrix, firstRow, secondRow);
            System.out.println("Матрица после обмена строк:");
        } else {
            System.out.println("Неверные номера строк.");
        }
        return matrix;
    }

    private void swapRows(int[][] matrix, int firstRow, int secondRow) {
        int[] temp = matrix[firstRow];
        matrix[firstRow] = matrix[secondRow];
        matrix[secondRow] = temp;
    }

    private int[][] transArrayToMatrix(int[][] matrix, int[] array) {
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = array[k];
                k++;
            }
        }
        return matrix;
    }

    public int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    private int[] transMatrixToArray(int [][] matrix) {
        int n = matrix.length * matrix[0].length;
        int[] array = new int[n];
        int k = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[k] = ints[j];
                k++;
            }
        }
        return array;
    }
}
