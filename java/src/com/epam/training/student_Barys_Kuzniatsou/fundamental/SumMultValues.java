package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//fourth task
public class SumMultValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);                     //объявление Scanner для ввода
        System.out.print("Enter the number of integers: ");
        int numVal = input.nextInt();                               //количества значений
        int[] array = new int[numVal];                              //объявление массива
        int i = 0;
        int sum = 0;
        int mult = 1;
        for (i = 0; i < numVal; i++)                                //инициализация массива + сложение и умножение
           {
           System.out.print("Enter value #" + (i+1) + ": ");
           array[i] = input.nextInt();
           sum += array[i];
           mult *= array[i];
           }
        System.out.println("RESULT: Sum=" + sum + " Mult=" + mult); //вывод результата
    }
}
