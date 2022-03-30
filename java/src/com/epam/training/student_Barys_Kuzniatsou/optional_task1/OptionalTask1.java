/*Задание. Ввести n чисел с консоли.
1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

2.     Вывести числа в порядке возрастания (убывания) значений их длины.

3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.*/
package com.epam.training.student_Barys_Kuzniatsou.optional_task1;

import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) {
        /*TASK 1*///----------------------------------------------------------------------------------------------------
        System.out.print("Enter the number of values: ");
        int arrayDimension = getIntValue();                                         // задаем количество значений (массива)

        int[] arrayOfValues = new int[arrayDimension];                              // объявляем массив чисел
        int[] arrayLengthOfElement = new int[arrayDimension];                       // объявляем массив для записи длинны чисел

        for (int i = 0; i < arrayDimension; i++) {
            System.out.print("Enter value #" + (i+1) + ": ");
            arrayOfValues[i] = getIntValue();                                       // инициализация массива значениями
            arrayLengthOfElement[i] = getLengthOfArrayElement(arrayOfValues[i]);    // записываем длинну каждого элемента
        }

        int maxLengthOfElement = getMaximumFromArray(arrayLengthOfElement);
        int minLengthOfElement = getMinimumFromArray(arrayLengthOfElement);

        System.out.println("[///////////////////////TASK 1///////////////////////]");
        System.out.println("[1 TASK] Max length: " + maxLengthOfElement + " Min length: " + minLengthOfElement);

        /*TASK 2*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 2///////////////////////]");
        int[] arrayOfLengthToSort = new int[arrayDimension];                                //массив для второго задания
        int[] arrayOfValuesToSort = new int[arrayDimension];                                //массив для второго задания

        System.arraycopy(arrayOfValues, 0, arrayOfValuesToSort, 0, arrayDimension);
        System.arraycopy(arrayLengthOfElement, 0, arrayOfLengthToSort, 0, arrayDimension);

        boolean flagSorted = false;                                             // bubble sort
        int bufferForLength, bufferForValue;                                    // переменные типа temp для bubble sort
        while (!flagSorted) {
            flagSorted = true;
            for (int i = 0; i < arrayDimension-1; i++) {
                if (arrayOfLengthToSort[i] > arrayOfLengthToSort[i+1]) {
                    flagSorted = false;

                    bufferForLength = arrayOfLengthToSort[i];
                    arrayOfLengthToSort[i] = arrayOfLengthToSort[i+1];
                    arrayOfLengthToSort[i+1] = bufferForLength;

                    bufferForValue = arrayOfValuesToSort[i];
                    arrayOfValuesToSort[i] = arrayOfValuesToSort[i+1];
                    arrayOfValuesToSort[i+1] = bufferForValue;
                }
            }
        }

        System.out.println("[2 TASK: Sorted from min to max length]");  //вывод результата task2 min->max
        for (int i = 0; i < arrayDimension; i++) {
            System.out.println("Length: " + arrayOfLengthToSort[i] + " Value: " + arrayOfValuesToSort[i]);
        }
        System.out.println("[2 TASK: Sorted from max to min length]");  //вывод результата task2 max->min
        for (int i = arrayDimension-1; i >= 0; i--) {
            System.out.println("Length: " + arrayLengthOfElement[i] + " Value: " + arrayOfValuesToSort[i]);
        }

        /*TASK 3*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 3///////////////////////]");
        int sumOfLength = getSumOfArrayElements(arrayLengthOfElement);
        int averageLength = getAverageValue(sumOfLength, arrayDimension);

        System.out.println("[3 TASK: Less than avg]");                                                  // меньше среднего
        for (int i = 0; i < arrayDimension; i++){
            if (arrayLengthOfElement[i] < averageLength){
                System.out.println("Value: " + arrayOfValues[i] + " Length: " + arrayLengthOfElement[i]);
            }
        }

        System.out.println("[3 TASK: More than avg]");                                                  // больше среднего
        for (int i = 0; i < arrayDimension; i++){
            if (arrayLengthOfElement[i] > averageLength){
                System.out.println("Value: " + arrayOfValues[i] + " Length: " + arrayLengthOfElement[i]);
            }
        }

        /*TASK 4*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 4///////////////////////]");
        int[][] arrayForNumbersOfValue = new int[arrayDimension][maxLengthOfElement];   // массив содержащий цифры числа
        int[] arrayTemp = new int[arrayDimension];                                      // изначальный массив
        int[][] numberRepeats =  new int[arrayDimension][10];                           // массив повторений
        int[] sumOfNumberRepeats =  new int[arrayDimension];
        int[] multiplyOfNumberRepeats =  new int[arrayDimension];


        for (int i = 0; i < arrayDimension; i++) {
            arrayTemp[i] = arrayOfValues[i];
            multiplyOfNumberRepeats[i] = 1;
        }

        for (int i = 0; i < arrayDimension; i++) {                                                  // создание из числа массива цифр
            for (int j = 0; j < (arrayLengthOfElement[i]); j++) {
                arrayForNumbersOfValue[i][j] = arrayTemp[i] % 10;
                arrayTemp[i] = arrayTemp[i] / 10;
            }
        }

        for (int i = 0; i < arrayDimension; i++) {                                                  // вывод массива цифр
            for (int j = 0; j < (arrayLengthOfElement[i]); j++) {
                System.out.print("\t" + arrayForNumbersOfValue[i][j]);
            }
            System.out.print("\n");
        }

        for (int i = 0; i < arrayDimension; i++) {
            for (int j = 0; j < arrayLengthOfElement[i]; j++) {
                switch (arrayForNumbersOfValue[i][j]) {
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

        for (int i = 0; i < arrayDimension; i++) {                                                  // вывод массива цифр
            System.out.print("Value [" + (i+1) + "] ");
            for (int j = 0; j < 10; j++) {
                System.out.print("\t" + numberRepeats[i][j]);
                sumOfNumberRepeats[i] += numberRepeats[i][j];
                if (numberRepeats[i][j] > 0) {
                    multiplyOfNumberRepeats[i] *= numberRepeats[i][j];
                }
            }
            System.out.print("\n");
        }

        for (int i = 0; i < arrayDimension; i++) {
            System.out.println((i+1) + " sum:" + sumOfNumberRepeats[i] + " mult:" + multiplyOfNumberRepeats[i]);
        }

        int minSum = 99;
        int minMult = 99;
        int k = 0;

        for (int i = 0; i < arrayDimension; i++) {
            if (multiplyOfNumberRepeats[i] <= minMult && sumOfNumberRepeats[i] < minSum) {
                minSum = sumOfNumberRepeats[i];
                minMult = multiplyOfNumberRepeats[i];
                k = i;
            }
        }

        System.out.println("\n" + "The minimum number of distinct digits in a number " + k + ": " + arrayOfValues[k]);



    }

    // task 1
    private static int getIntValue() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }
    // task 1
    private static int getLengthOfArrayElement(int valueToLength) {
        String valueString = String.valueOf(valueToLength);         // преобразования числа в строку
        return valueString.length();                                // вычисление длины строки
    }
    // task 1
    private static int getMaximumFromArray(int[] array) {
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxValue <= array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    // task 1
    private static int getMinimumFromArray(int[] array) {
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minValue >= array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }
    // task 3
    private static int getSumOfArrayElements(int[] arrayOfLengths) {
        int sumOfLengths = 0;
        for (int i = 0; i < arrayOfLengths.length; i++){
            sumOfLengths += arrayOfLengths[i];
        }
        return sumOfLengths;
    }
    // task 3
    private static int getAverageValue(int numerator, int denominator) {
        float averageResult = (float) numerator/(float)denominator;
        System.out.println("Average length: " + averageResult);
        return (int)Math.round(averageResult);
    }

}
