package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//first task    1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class HelloUser {
    public static void main(String[] args) {
        sayHelloToUser(getName());
    }

    static public String getName() {
        Scanner inputFromConsole = new Scanner(System.in);
            System.out.print("Enter your name: ");
            return inputFromConsole.nextLine();
    }

    static public void sayHelloToUser(String userName) {
        System.out.println("\nHello " + userName);
    }
}
