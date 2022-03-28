/*Задание. Ввести n чисел с консоли.
1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

2.     Вывести числа в порядке возрастания (убывания) значений их длины.

3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.*/
package com.epam.training.student_Barys_Kuzniatsou.optional_task1;

import java.util.Scanner;
import java.util.Arrays;

public class OptionalTask1 {
    public static void main(String[] args) {
        /*TASK 1*///----------------------------------------------------------------------------------------------------
        Scanner input = new Scanner(System.in);                    //объявляем сканнер

        int numVal = 0;                                            //количество n
        int i = 0, j =0, k=0;                                      //переменные цикла
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
            if (maxLenth <= arrayValueLength[i]) {
                maxLenth = arrayValueLength[i];
            } else if(minLenth >= arrayValueLength[i]){
                minLenth = arrayValueLength[i];
            }
            //System.out.println("Value: " + arrayValues[i] + " with Length: " + arrayValueLength[i]);// вывод Value and
        }                                                                                             // length of Value
        System.out.println("[///////////////////////TASK 1///////////////////////]");
        System.out.println("[1 TASK] Max length: " + maxLenth + " Min length: " + minLenth);          // вывод max & min

        /*TASK 2*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 2///////////////////////]");
        int[] task2ArrayValueLength = new int[numVal];             //массив для второго задания
        int[] task2arrayValues = new int[numVal];                  //массив для второго задания

        /*for (i = 0; i < numVal; i++){                              //копирование массивов
            task2arrayValues[i] = arrayValues[i];
            task2ArrayValueLength[i] = arrayValueLength[i];
        }*/

        System.arraycopy(arrayValues, 0, task2arrayValues, 0, numVal);              //копирование массивов
        System.arraycopy(arrayValueLength, 0, task2ArrayValueLength, 0, numVal);    //копирование массивов

        boolean flagSorted = false;                                     // bubble sort
        int buf, buf2;                                                  // переменные типа temp для bubble sort
        while(!flagSorted) {                                            // пока не отсортирован
            flagSorted = true;                                          // задаем значение отсортирован в случае, если не зайдем в if
            for (i = 0; i < numVal-1; i++) {
                if(task2ArrayValueLength[i] > task2ArrayValueLength[i+1]){
                    flagSorted = false;                                 // flag не отсортирован для while

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
        int avgLength = sumOfLength/numVal;                 // среднее количество цифр в числе

        System.out.println("AvgLength: " + avgLength);
        System.out.println("[3 TASK: Less than avg]");      // меньше среднего
        for (i = 0; i < numVal; i++){
            if (arrayValueLength[i] < avgLength){
                System.out.println("Value: " + arrayValues[i] + " Length: " + arrayValueLength[i]);
            }
        }

        System.out.println("[3 TASK: More than avg]"); // больше среднего
        for (i = 0; i < numVal; i++){
            if (arrayValueLength[i] > avgLength){
                System.out.println("Value: " + arrayValues[i] + " Length: " + arrayValueLength[i]);
            }
        }

        /*TASK 4*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 4///////////////////////]");
        int[][] arrayNumbVal = new int[numVal][maxLenth];                               // массив содержащий цифры числа
        int[] arrayValuesTask4 = new int[numVal];                                       // изначальный массив
        int[][] numberRepeats =  new int[numVal][10];                                   // массив повторений
        int[] sumOfnumberRepeats =  new int[numVal];                                    //
        int[] multOfnumberRepeats =  new int[numVal];
        //System.arraycopy(arrayValues, 0, arrayValuesTask4, 0, numVal);                // исходный массив для задания 4

        for (i = 0; i < numVal; i++) {                                                  //копирование массивов
            arrayValuesTask4[i] = arrayValues[i];
            multOfnumberRepeats[i] = 1;
        }

        for (i = 0; i < numVal; i++) {                                                  // создание из числа массив цифр
            for (j = 0; j < (arrayValueLength[i]); j++) {
                arrayNumbVal[i][j] = arrayValuesTask4[i] % 10;
                arrayValuesTask4[i] = arrayValuesTask4[i] / 10;
            }
        }

        for (i = 0; i < numVal; i++) {                                                  // вывод массива цифр
            for (j = 0; j < (arrayValueLength[i]); j++) {
                System.out.print("\t" + arrayNumbVal[i][j]);
            }
            System.out.print("\n");
        }

        for (i = 0; i < numVal; i++) {
            for (j = 0; j < arrayValueLength[i]; j++) {
                switch (arrayNumbVal[i][j]) {
                    case 0: numberRepeats [i][0] +=1; break;
                    case 1: numberRepeats [i][1] +=1; break;
                    case 2: numberRepeats [i][2] +=1; break;
                    case 3: numberRepeats [i][3] +=1; break;
                    case 4: numberRepeats [i][4] +=1; break;
                    case 5: numberRepeats [i][5] +=1; break;
                    case 6: numberRepeats [i][6] +=1; break;
                    case 7: numberRepeats [i][7] +=1; break;
                    case 8: numberRepeats [i][8] +=1; break;
                    case 9: numberRepeats [i][9] +=1; break;
                    default: System.out.println("Something wrong"); break;
                };
            }

        }

        for (i = 0; i < numVal; i++) {                                                  // вывод массива цифр
            System.out.print("Value [" + (i+1) + "] ");
            for (j = 0; j < 10; j++) {
                System.out.print("\t" + numberRepeats[i][j]);
                sumOfnumberRepeats[i] += numberRepeats[i][j];
                if (numberRepeats[i][j] > 0) {
                    multOfnumberRepeats[i] *= numberRepeats[i][j];
                }
            }
            System.out.print("\n");
        }

        for (i = 0; i < numVal; i++) {
            System.out.println((i+1) + " sum:" + sumOfnumberRepeats[i] + " mult:" + multOfnumberRepeats[i]);
        }

        int minSum = sumOfnumberRepeats[0];
        int minMult = multOfnumberRepeats[0];
        k = 0;

        for (i = 1; i < numVal; i++) {
            if (multOfnumberRepeats[i] <= minMult && sumOfnumberRepeats[i] < minSum) {
                minSum = sumOfnumberRepeats[i];
                minMult = multOfnumberRepeats[i];
                k = i;
            }
        }

        System.out.println("\n" + "The minimum number of distinct digits in a number: " + arrayValues[k]);



    }
}
