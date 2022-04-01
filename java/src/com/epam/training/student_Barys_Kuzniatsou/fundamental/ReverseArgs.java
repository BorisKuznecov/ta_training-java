package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//second task   2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
public class ReverseArgs {
    public static void main(String[] args) {
        Scanner inputFromConsole = new Scanner(System.in);
        System.out.print("Enter string to reverse: ");
        String stringEntry =  inputFromConsole.nextLine();
        StringBuffer bufferForStringEntry = new StringBuffer(stringEntry);
        System.out.println("Reverse string: " + bufferForStringEntry.reverse());
    }
}
