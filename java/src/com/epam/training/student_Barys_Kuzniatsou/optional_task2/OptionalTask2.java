package com.epam.training.student_Barys_Kuzniatsou.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix dimension: ");
        int nMatrixDimension = input.nextInt();                                 // ввод размерности квадратной матрицы
        int[][] array = new int[nMatrixDimension][nMatrixDimension];            // изначальная матрица
        Random random = new Random();
        System.out.print("Enter upperbound (lowerbound with minus): ");
        int upperbound = input.nextInt();                                       // М макс значения
        int lowerbound = -upperbound;                                           // М мин значения
        int i = 0;                                                              // i, j переменные цикла for
        int j = 0;

        for (i = 0; i < nMatrixDimension; i++) {                                // инициализация массива
            for (j = 0; j < nMatrixDimension; j++) {
                array[i][j] = random.nextInt(upperbound-lowerbound) + lowerbound;
            }
        }
        System.out.println("Matrix: ");                                         // вывод массива
        for (i = 0; i < nMatrixDimension; i++) {
            for (j = 0; j < nMatrixDimension; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println("\n");
        }
        /*TASK 1*///----------------------------------------------------------------------------------------------------
        int k = 0;                                                              // k-переменная = строка (столбец) для сортировки
        int[][] arrayTask1c = new int[nMatrixDimension][nMatrixDimension];      // arrayTask1 c/r для первого задания
        int[][] arrayTask1r = new int[nMatrixDimension][nMatrixDimension];

        for (i = 0; i < nMatrixDimension; i++) {                                // инициализация массивов
            for (j = 0; j < nMatrixDimension; j++) {
                arrayTask1c[i][j] = array[i][j];
                arrayTask1r[i][j] = array[i][j];
            }
        }

        do {
            System.out.print("\nEnter k-sorted (column/row): ");
            k = input.nextInt();
        } while (k+2 >= nMatrixDimension);

        boolean flagSorted = false;                                     // bubble sort COLUMN
        int buf;                                                        // переменная типа temp для bubble sort
        while(!flagSorted) {                                            // пока не отсортирован
            flagSorted = true;                                          // задаем значение отсортирован в случае, если не зайдем в if
            for (i = 0; i < nMatrixDimension; i++) {
                for (j = k; j < nMatrixDimension-1; j++) {
                    if(arrayTask1c[i][j] > arrayTask1c[i][j+1]){
                        flagSorted = false;                             // flag не отсортирован для while

                        buf = arrayTask1c[i][j];
                        arrayTask1c[i][j] = arrayTask1c[i][j+1];
                        arrayTask1c[i][j+1] = buf;
                    }
                }
            }
        }

        flagSorted = false;                                             // bubble sort ROW
        while(!flagSorted) {                                            // пока не отсортирован
            flagSorted = true;                                          // задаем значение отсортирован в случае, если не зайдем в if
            for (j = 0; j < nMatrixDimension; j++) {
                for (i = k; i < nMatrixDimension-1; i++) {
                    if(arrayTask1r[i][j] > arrayTask1r[i+1][j]){
                        flagSorted = false;                             // flag не отсортирован для while

                        buf = arrayTask1r[i][j];
                        arrayTask1r[i][j] = arrayTask1r[i+1][j];
                        arrayTask1r[i+1][j] = buf;
                    }
                }
            }
        }

        System.out.println("Matrix Sorted (c): ");                      // вывод отсортированных массивов
        for (i = 0; i < nMatrixDimension; i++) {
            for (j = 0; j < nMatrixDimension; j++) {
                System.out.print(" " + arrayTask1c[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("Matrix Sorted (r): ");
        for (i = 0; i < nMatrixDimension; i++) {
            for (j = 0; j < nMatrixDimension; j++) {
                System.out.print(" " + arrayTask1r[i][j]);
            }
            System.out.println("\n");
        }

        /*TASK 4*///----------------------------------------------------------------------------------------------------
        int[][] arrayTask4 = new int[nMatrixDimension][nMatrixDimension];   // массив для задания 4
        int valueMax = 0;                                                   // максимальный элемент
        int valueMaxColumn = 0;                                             // графа с максимальным элементом
        int valueMaxRow = 0;                                                // строка с максимальным элементом

        for (i = 0; i < nMatrixDimension; i++) {
            for (j = 0; j < nMatrixDimension; j++) {
                arrayTask4[i][j] = array [i][j];
            }
        }

        for (i = 0; i < nMatrixDimension; i++) {
            for (j = 0; j < nMatrixDimension; j++) {
                if (arrayTask4[i][j] > valueMax) {
                    valueMax = arrayTask4[i][j];
                }
            }
        }
    }
}
