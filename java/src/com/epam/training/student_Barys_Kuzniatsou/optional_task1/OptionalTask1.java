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
        int arrayDimension = getIntValue();                                         

        int[] arrayOfValues = new int[arrayDimension];                              
        int[] arrayLengthOfElement = new int[arrayDimension];                       

        for (int i = 0; i < arrayDimension; i++) {
            System.out.print("Enter value #" + (i+1) + ": ");
            arrayOfValues[i] = getIntValue();                                       
            arrayLengthOfElement[i] = setLengthOfArrayElement(arrayOfValues[i]);    
        }

        int maxLengthOfElement = setMaximumFromArray(arrayLengthOfElement);
        int minLengthOfElement = setMinimumFromArray(arrayLengthOfElement);

        System.out.println("[///////////////////////TASK 1///////////////////////]");
        System.out.println("[1 TASK] Max length: " + maxLengthOfElement + " Min length: " + minLengthOfElement);

        /*TASK 2*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 2///////////////////////]");
        int[] arrayOfLengthToSort = new int[arrayDimension];                                
        int[] arrayOfValuesToSort = new int[arrayDimension];                                

        System.arraycopy(arrayOfValues, 0, arrayOfValuesToSort, 0, arrayDimension);
        System.arraycopy(arrayLengthOfElement, 0, arrayOfLengthToSort, 0, arrayDimension);

        boolean flagSorted = false;                                             
        int bufferForLength, bufferForValue;                                    
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

        System.out.println("[2 TASK: Sorted from min to max length]");
        for (int i = 0; i < arrayDimension; i++) {
            System.out.println("Length: " + arrayOfLengthToSort[i] + " Value: " + arrayOfValuesToSort[i]);
        }
        System.out.println("[2 TASK: Sorted from max to min length]"); 
        for (int i = arrayDimension-1; i >= 0; i--) {
            System.out.println("Length: " + arrayOfLengthToSort[i] + " Value: " + arrayOfValuesToSort[i]);
        }

        /*TASK 3*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 3///////////////////////]");
        int sumOfLength = setSumOfArrayElements(arrayLengthOfElement);
        int averageLength = setAverageValue(sumOfLength, arrayDimension);

        //System.out.println("AVG LENTH " + averageLength);

        System.out.println("[3 TASK: Less than avg]");                                                  
        for (int i = 0; i < arrayDimension; i++) {
            if (arrayLengthOfElement[i] < averageLength) {
                System.out.println("Value: " + arrayOfValues[i] + " Length: " + arrayLengthOfElement[i]);
            }
        }

        System.out.println("[3 TASK: More than avg]");                                                  
        for (int i = 0; i < arrayDimension; i++) {
            if (arrayLengthOfElement[i] > averageLength) {
                System.out.println("Value: " + arrayOfValues[i] + " Length: " + arrayLengthOfElement[i]);
            }
        }

        /*TASK 4*///----------------------------------------------------------------------------------------------------
        System.out.println("[///////////////////////TASK 4///////////////////////]");
        int[][] arrayForNumbersOfArrayValue = new int[arrayDimension][maxLengthOfElement];
        int[] arrayTemp = new int[arrayDimension];                                      // изначальный массив
        int[][] numberRepeatsInArrayValue =  new int[arrayDimension][10];
        int[] sumOfNumberRepeats =  new int[arrayDimension];
        int[] multiplyOfNumberRepeats =  new int[arrayDimension];


        for (int i = 0; i < arrayDimension; i++) {
            arrayTemp[i] = arrayOfValues[i];
            multiplyOfNumberRepeats[i] = 1;
        }

        for (int i = 0; i < arrayDimension; i++) {
            for (int j = 0; j < (arrayLengthOfElement[i]); j++) {
                arrayForNumbersOfArrayValue[i][j] = arrayTemp[i] % 10;
                arrayTemp[i] = arrayTemp[i] / 10;
            }
        }

//        for (int i = 0; i < arrayDimension; i++) {
//            for (int j = 0; j < (arrayLengthOfElement[i]); j++) {
//                System.out.print("\t" + arrayForNumbersOfValue[i][j]);
//            }
//            System.out.print("\n");


        for (int i = 0; i < arrayDimension; i++) {
            for (int j = 0; j < arrayLengthOfElement[i]; j++) {
                switch (arrayForNumbersOfArrayValue[i][j]) {
                    case 0: numberRepeatsInArrayValue [i][0] +=1; break;
                    case 1: numberRepeatsInArrayValue [i][1] +=1; break;
                    case 2: numberRepeatsInArrayValue [i][2] +=1; break;
                    case 3: numberRepeatsInArrayValue [i][3] +=1; break;
                    case 4: numberRepeatsInArrayValue [i][4] +=1; break;
                    case 5: numberRepeatsInArrayValue [i][5] +=1; break;
                    case 6: numberRepeatsInArrayValue [i][6] +=1; break;
                    case 7: numberRepeatsInArrayValue [i][7] +=1; break;
                    case 8: numberRepeatsInArrayValue [i][8] +=1; break;
                    case 9: numberRepeatsInArrayValue [i][9] +=1; break;
                    default: System.out.println("Something wrong"); break;
                };
            }

        }

        for (int i = 0; i < arrayDimension; i++) {
            //System.out.print("Value [" + (i+1) + "] ");
            for (int j = 0; j < 10; j++) {
                //System.out.print("\t" + numberRepeats[i][j]);
                sumOfNumberRepeats[i] += numberRepeatsInArrayValue[i][j];
                if (numberRepeatsInArrayValue[i][j] > 0) {
                    multiplyOfNumberRepeats[i] *= numberRepeatsInArrayValue[i][j];
                }
            }
            //System.out.print("\n");
        }

//        for (int i = 0; i < arrayDimension; i++) {
//            System.out.println((i+1) + " sum:" + sumOfNumberRepeats[i] + " mult:" + multiplyOfNumberRepeats[i]);
//        }

        int minOfSum = 99;
        int minOfMultiply = 99;
        int k = 0;

        for (int i = 0; i < arrayDimension; i++) {
            if (multiplyOfNumberRepeats[i] <= minOfMultiply && sumOfNumberRepeats[i] < minOfSum) {
                minOfSum = sumOfNumberRepeats[i];
                minOfMultiply = multiplyOfNumberRepeats[i];
                k = i;
            }
        }

        System.out.println("\n" + "The minimum number of distinct digits in a number " + k + ": " + arrayOfValues[k]);



    }


    private static int getIntValue() {
        Scanner inputFromConsole = new Scanner(System.in);
        return inputFromConsole.nextInt();
    }

    private static int setLengthOfArrayElement(int valueToLength) {
        String valueString = String.valueOf(valueToLength);
        return valueString.length();
    }

    private static int setMaximumFromArray(int[] array) {
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxValue <= array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    private static int setMinimumFromArray(int[] array) {
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minValue >= array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    private static int setSumOfArrayElements(int[] arrayOfLengths) {
        int sumOfLengths = 0;
        for (int i = 0; i < arrayOfLengths.length; i++){
            sumOfLengths += arrayOfLengths[i];
        }
        return sumOfLengths;
    }

    private static int setAverageValue(int numerator, int denominator) {
        float averageResult = (float) numerator/(float)denominator;
        //System.out.println("Average length: " + averageResult);
        return (int)Math.round(averageResult);
    }

}
