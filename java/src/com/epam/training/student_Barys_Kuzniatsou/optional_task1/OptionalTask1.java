package com.epam.training.student_Barys_Kuzniatsou.optional_task1;

import java.util.Scanner;
import java.util.Arrays;

public class OptionalTask1 {
    public static void main(String[] args) {
        /*TASK 1*///----------------------------------------------------------------------------------------------------
        Scanner input = new Scanner(System.in);                    //объявляем сканнер

        int numVal = 0;                                            //количество n
        int i = 0;                                                 //переменная цикла
        System.out.print("Enter the number of values: ");
        numVal = input.nextInt();                                  //задаем количество значений

        int[] arrayValues = new int[numVal];                       //объявляем массив значений
        String[] arrayLenString = new String[numVal];              //объявление строкового массива
        int[] arrayValueLength = new int[numVal];                  //объявление массива для записис длинны

        for (i = 0; i < numVal; i++){
            System.out.print("Enter value #" + (i+1) + ": ");
            arrayValues[i] = input.nextInt();                      //инициализация массива значениями
            arrayLenString[i] = String.valueOf(arrayValues[i]);    //преобразования числа в строку
            arrayValueLength[i] = (arrayLenString[i]).length();    //вычисление длины строки (записываем в массив чисел)
        }

        int minLenth = 1;                                          //минимальная длина
        int maxLenth = arrayValueLength[0];                        //максимальная длина

        for (i = 0; i < numVal; i++){
            if (minLenth <= arrayValueLength[i]) {
                minLenth = arrayValueLength[i];
            } else if(maxLenth >= arrayValueLength[i]){
                maxLenth = arrayValueLength[i];
            }
            //System.out.println("Value: " + arrayValues[i] + " with Length: " + arrayValueLength[i]);// вывод Value and
        }                                                                                             // length of Value
        System.out.println("[///////////////////////TASK 1///////////////////////]");
        System.out.println("[1 TASK] Max length: " + maxLenth + " Min length: " + minLenth);          // вывод max & min

        /*TASK 2*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 2///////////////////////]");
        int[] task2ArrayValueLength = new int[numVal];             //массив для второго задания
        int[] task2arrayValues = new int[numVal];                  //массив для второго задания

        for (i = 0; i < numVal; i++){                              //копирование массивов
            task2arrayValues[i] = arrayValues[i];
            task2ArrayValueLength[i] = arrayValueLength[i];
        }

        boolean Sorted = false;                                     //bubble sort
        int buf, buf2;
        while(!Sorted) {
            Sorted = true;
            for (i = 0; i < numVal-1; i++) {
                if(task2ArrayValueLength[i] > task2ArrayValueLength[i+1]){
                    Sorted = false;

                    buf = task2ArrayValueLength[i];
                    task2ArrayValueLength[i] = task2ArrayValueLength[i+1];
                    task2ArrayValueLength[i+1] = buf;

                    buf2 = task2arrayValues[i];
                    task2arrayValues[i] = task2arrayValues[i+1];
                    task2arrayValues[i+1] = buf2;
                }
            }
        }

        System.out.println("[2 TASK: Sorted from min to max length]");  //вывод результата task2 min->max
        for (i = 0; i < numVal; i++){
            System.out.println("Length: " + task2ArrayValueLength[i] + " Value: " + task2arrayValues[i]);
        }
        System.out.println("[2 TASK: Sorted from max to min length]");  //вывод результата task2 max->min
        for (i = numVal-1; i >= 0; i--){
            System.out.println("Length: " + task2ArrayValueLength[i] + " Value: " + task2arrayValues[i]);
        }

        /*TASK 3*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 3///////////////////////]");
        int sumOfLength = 0;

        for (i = 0; i < numVal; i++){
            sumOfLength += arrayValueLength[i];
        }
        int avgLength = sumOfLength/numVal;

        //System.out.println("AvgLength: " + avgLength);
        System.out.println("[3 TASK: Less than avg]");
        for (i = 0; i < numVal; i++){
            if (arrayValueLength[i] < avgLength){
                System.out.println("Value: " + arrayValues[i] + " Length: " + arrayValueLength[i]);
            }

        }
        System.out.println("[3 TASK: More than avg]");
        for (i = 0; i < numVal; i++){
            if (arrayValueLength[i] > avgLength){
                System.out.println("Value: " + arrayValues[i] + " Length: " + arrayValueLength[i]);
            }

        }

    }
}
