package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;
//second task
public class ReverseArgs {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter string: ");                 //ввод строки
    String stringEntry =  input.nextLine();             //инициализация переменной
    StringBuffer buffer = new StringBuffer(stringEntry);//объявление и инициализация StringBuffer с переменной buffer
    buffer.reverse();                                   //метод reverse()
    System.out.println(buffer);                         //вывод в консоль переменной buffer
    }
}
