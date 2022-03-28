package com.epam.training.student_Barys_Kuzniatsou.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix dimension: ");
        int nMatrixDimension = input.nextInt();
        int[][] array = new int[nMatrixDimension][nMatrixDimension];
        Random random = new Random();
        System.out.print("Enter upperbound (lowerbound with minus): ");
        int upperbound = input.nextInt();
        int lowerbound = -upperbound;

        for (int i = 0; i < nMatrixDimension; i++) {
            for (int j = 0; j < nMatrixDimension; j++) {
                array[i][j] = random.nextInt(upperbound-lowerbound) + lowerbound;
            }
        }

        for (int i = 0; i < nMatrixDimension; i++) {
            for (int j = 0; j < nMatrixDimension; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println("\n");
        }


    }
}
