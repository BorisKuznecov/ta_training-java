package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//third task
public class OutputLineBreak {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);         //объявляем Scanner
    System.out.print("Enter number of values: ");   //вывод запроса на количество значений
    int numValues = input.nextInt();                //присвоение переменной количества значений
    double[] array = new double[numValues];         //объявление массмва
    int i = 0;                                      //инициализация переменной цикла

    Random random = new Random();                   //объявляем Random

    for (i = 0; i < numValues; i++)                 //цикл инициализации массива
       {
       array[i] = random.nextDouble();
       System.out.println("Random value №" + (i+1)+ ": " + array[i]);
       }

    System.out.println("Output of values in line: ");
    /*for (i = 0; i < numValues; i++)                 //цикл вывода значений без перехода на новую строку
       {
       System.out.print(array[i] + " ");            //добавлен пробел для читаемости
       }*/
    System.out.println(Arrays.toString(array));
    System.out.println("\n");                       //разделение вывода

    System.out.println("Output of values (new line): ");
    for (i = 0; i < numValues; i++)                 //цикл вывода значений с новой строки
       {
       System.out.println(array[i]);
       }
    }

}
