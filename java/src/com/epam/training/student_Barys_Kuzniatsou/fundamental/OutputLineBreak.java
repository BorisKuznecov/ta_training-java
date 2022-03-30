package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//third task    3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class OutputLineBreak {
    public static void main(String[] args) {
        System.out.print("Enter number of values: ");
        int arrayDimension = getIntValueFromConsole();                              // размерность массива

        double[] array = new double[arrayDimension];                                // объявление массива
        for (int i = 0; i < arrayDimension; i++) {                                  // цикл ининциализации массива значениями
            array[i] = getRandomDoubleValue();
        }

        arrayPrintToConsoleValuesInOneLine(array);                                  // вывод в одну строку
        arrayPrintToConsoleValuesInNewline(array);                                  // вывод с новой строки
    }

    private static int getIntValueFromConsole() {
        Scanner inputFromConsole = new Scanner(System.in);                          //объявляем Scanner
        return inputFromConsole.nextInt();                                          // возвращаем значение из консоли
    }

    private static double getRandomDoubleValue() {
        Random randomDoubleValue = new Random();                                    // объявляем Random
        return randomDoubleValue.nextDouble();                                      // возвращаем случайное значение
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
