package com.epam.training.student_Barys_Kuzniatsou.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {
    public static void main(String[] args) {
        System.out.print("Enter matrix dimension: ");
        int dimensionOfSquareMatrix = getIntValue();
        System.out.print("Enter positive upperbound value M (lowerbound will be -M): ");
        int upperbound = Math.abs(getIntValue());
        int lowerbound = -upperbound;

        int[][] matrix = new int[dimensionOfSquareMatrix][dimensionOfSquareMatrix];
        for (int i = 0; i < dimensionOfSquareMatrix; i++) {
            for (int j = 0; j < dimensionOfSquareMatrix; j++) {
                matrix[i][j] = getRandomIntValue(upperbound, lowerbound);
            }
        }
        System.out.println("Matrix: ");
        printMatrix(matrix, dimensionOfSquareMatrix, dimensionOfSquareMatrix);

        /*TASK 1*///----------------------------------------------------------------------------------------------------
        int numberColumnRowToSort = 0;
        int[][] matrixSortedByColumn = new int[dimensionOfSquareMatrix][dimensionOfSquareMatrix];
        int[][] matrixSortedByRow = new int[dimensionOfSquareMatrix][dimensionOfSquareMatrix];

        for (int i = 0; i < dimensionOfSquareMatrix; i++) {
            for (int j = 0; j < dimensionOfSquareMatrix; j++) {
                matrixSortedByColumn[i][j] = matrix[i][j];
                matrixSortedByRow[i][j] = matrix[i][j];
            }
        }

        do {
            System.out.print("\nEnter k-sorted (column/row): ");
            numberColumnRowToSort = getIntValue()+1;
        } while (numberColumnRowToSort+1 >= dimensionOfSquareMatrix);

        boolean flagMatrixSorted = false;
        int bufferForMatrixElement;
        while(!flagMatrixSorted) {
            flagMatrixSorted = true;
            for (int i = 0; i < dimensionOfSquareMatrix; i++) {
                for (int j = numberColumnRowToSort; j < dimensionOfSquareMatrix-1; j++) {
                    if(matrixSortedByColumn[i][j] > matrixSortedByColumn[i][j+1]){
                        flagMatrixSorted = false;

                        bufferForMatrixElement = matrixSortedByColumn[i][j];
                        matrixSortedByColumn[i][j] = matrixSortedByColumn[i][j+1];
                        matrixSortedByColumn[i][j+1] = bufferForMatrixElement;
                    }
                }
            }
        }

        flagMatrixSorted = false;
        while(!flagMatrixSorted) {
            flagMatrixSorted = true;
            for (int j = 0; j < dimensionOfSquareMatrix; j++) {
                for (int i = numberColumnRowToSort; i < dimensionOfSquareMatrix-1; i++) {
                    if(matrixSortedByRow[i][j] > matrixSortedByRow[i+1][j]){
                        flagMatrixSorted = false;

                        bufferForMatrixElement = matrixSortedByRow[i][j];
                        matrixSortedByRow[i][j] = matrixSortedByRow[i+1][j];
                        matrixSortedByRow[i+1][j] = bufferForMatrixElement;
                    }
                }
            }
        }

        System.out.println("Matrix Sorted (column): ");
        printMatrix(matrixSortedByColumn, dimensionOfSquareMatrix, dimensionOfSquareMatrix);
        System.out.println("Matrix Sorted (row): ");
        printMatrix(matrixSortedByRow, dimensionOfSquareMatrix, dimensionOfSquareMatrix);


        /*TASK 4*///----------------------------------------------------------------------------------------------------
        int[][] matrixToDeletElement = new int[dimensionOfSquareMatrix][dimensionOfSquareMatrix];
        int maximumValue = getMaximumValueFromMatrix(matrix, dimensionOfSquareMatrix, dimensionOfSquareMatrix);

        for (int i = 0; i < dimensionOfSquareMatrix; i++) {
            for (int j = 0; j < dimensionOfSquareMatrix; j++) {
                matrixToDeletElement[i][j] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < dimensionOfSquareMatrix; i++) {
            for (int j = 0; j < dimensionOfSquareMatrix; j++) {
                if(matrixToDeletElement[i][j] == maximumValue) {
                    for (int m = 0; m < dimensionOfSquareMatrix; m++) {
                            matrixToDeletElement[m][j] = 0;
                            matrixToDeletElement[i][m] = 0;
                    }
                }
            }
        }

        System.out.println("Matrix with deleted maximum value: ");
        printMatrix(matrixToDeletElement, dimensionOfSquareMatrix, dimensionOfSquareMatrix);
    }

    private static void printMatrix(int[][] matrixToPrint, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" " + matrixToPrint[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static int getIntValue() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }

    private static int getRandomIntValue(int upperbound, int lowerbound) {
        Random random = new Random();
        return random.nextInt(upperbound-lowerbound) + lowerbound;
    }

    private static int getMaximumValueFromMatrix(int[][] matrixToFindMaxElement, int rows, int columns) {
        int maxElementInMatrix = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrixToFindMaxElement[i][j] > maxElementInMatrix) {
                    maxElementInMatrix = matrixToFindMaxElement[i][j];
                }
            }
        }
        return maxElementInMatrix;
    }
}
