package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//fourth task   4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
public class SumMultValues {
    public static void main(String[] args) {
        System.out.print("Enter the number of integers: ");
        int arrayDimension = getIntValue();
        int[] array = new int[arrayDimension];

        for (int i = 0; i < arrayDimension; i++) {
            System.out.print("Enter value #" + (i+1) + ": ");
            array[i] = getIntValue();
        }

        System.out.println("RESULT: Sum=" + sumOfArrayValues(array) + " Multiply=" + multiplyOfArrayValues(array));
    }

    private static int getIntValue() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }

    private static int sumOfArrayValues(int[] arrayValuesToSum) {
        int sumOfArrayElements = 0;
        for (int i = 0; i < arrayValuesToSum.length; i++) {
            sumOfArrayElements += arrayValuesToSum[i];
        }
        return sumOfArrayElements;
    }

    private static int multiplyOfArrayValues(int[] arrayValuesToMultiply) {
        int multiplyOfArrayElements = 1;
        for (int i = 0; i < arrayValuesToMultiply.length; i++) {
            multiplyOfArrayElements *= arrayValuesToMultiply[i];
        }
        return multiplyOfArrayElements;
    }

}
