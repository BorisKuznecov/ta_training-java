package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;
//first task
public class HelloUser {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String nameUser = input.nextLine();
    System.out.println("\nHello " + nameUser);
    }
}
