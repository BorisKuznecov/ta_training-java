package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//fifth task    5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
public class MonthNum {
    public static void main(String[] args) {
        int monthNumber = getNumberOfMonthFromConsole();
        identifyMonthByNumber(monthNumber);
    }

    private static int getNumberOfMonthFromConsole() {
        Scanner inputFromConsole = new Scanner(System.in);
        System.out.print("Enter the number of month: ");
        return inputFromConsole.nextInt();
    }

    private static void identifyMonthByNumber(int monthNumberToSwitch) {
        System.out.print("The " + monthNumberToSwitch + " number of the month is ");
        switch (monthNumberToSwitch) {
            case(1): System.out.print("January"); break;
            case(2): System.out.print("February"); break;
            case(3): System.out.print("March"); break;
            case(4): System.out.print("April"); break;
            case(5): System.out.print("May"); break;
            case(6): System.out.print("June"); break;
            case(7): System.out.print("July"); break;
            case(8): System.out.print("August"); break;
            case(9): System.out.print("September"); break;
            case(10): System.out.print("October"); break;
            case(11): System.out.print("November"); break;
            case(12): System.out.print("December"); break;
            default: System.out.print("Error data"); break;
        }
    }
}
