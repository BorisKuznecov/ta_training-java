package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//third task    3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class OutputLineBreak {
    public static void main(String[] args) {
        System.out.print("Enter number of values: ");
        int arrayDimension = getIntValueFromConsole();

        double[] array = new double[arrayDimension];
        for (int i = 0; i < arrayDimension; i++) {
            array[i] = getRandomDoubleValue();
        }

        arrayPrintToConsoleValuesInOneLine(array);                                  // вывод в одну строку
        arrayPrintToConsoleValuesInNewline(array);                                  // вывод с новой строки
    }

    private static int getIntValueFromConsole() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }

    private static double getRandomDoubleValue() {
        Random randomDoubleValue = new Random();
        return randomDoubleValue.nextDouble();
    }

    private static void arrayPrintToConsoleValuesInOneLine(double[] arrayToPrint) {
        System.out.println("\nOutput of values in line: " + Arrays.toString(arrayToPrint));
    }

    private static void arrayPrintToConsoleValuesInNewline(double[] arrayToPrint) {
        System.out.println("\nOutput of values (newline): ");
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.println(arrayToPrint[i]);
        }
    }
}
