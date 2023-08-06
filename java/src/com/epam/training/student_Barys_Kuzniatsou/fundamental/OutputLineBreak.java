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
        arrayInitialization(array);
        
        arrayPrintToConsoleValuesInOneLine(array);                                  // вывод в одну строку
        arrayPrintToConsoleValuesInNewline(array);                                  // вывод с новой строки
    }

    private static void arrayInitialization(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomDoubleValue();
        }
    }

    private static int getIntValueFromConsole() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }

    private static double getRandomDoubleValue() {
        Random randomDoubleValue = new Random();
        return randomDoubleValue.nextDouble();
    }

    private static void arrayPrintToConsoleValuesInOneLine(double[] array) {
        System.out.println("\nOutput of values in line: " + Arrays.toString(array));
    }

    private static void arrayPrintToConsoleValuesInNewline(double[] array) {
        System.out.println("\nOutput of values (newline): ");
        for (double element : array) {
            System.out.println(element);
        }
    }
}
