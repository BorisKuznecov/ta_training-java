package com.epam.training.student_Barys_Kuzniatsou.fundamental;

import java.util.Scanner;

//fifth task
public class MonthNum {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int monthNum = 0;
    do
    {
    System.out.print("Enter the number of month: ");
    monthNum = input.nextInt();
    } while (monthNum > 12 || monthNum < 1);

    switch(monthNum)
    {
    case(1): System.out.println("Jan"); break;
    case(2): System.out.println("Feb"); break;
    case(3): System.out.println("Mar"); break;
    case(4): System.out.println("Apr"); break;
    case(5): System.out.println("May"); break;
    case(6): System.out.println("Jun"); break;
    case(7): System.out.println("Jul"); break;
    case(8): System.out.println("Aug"); break;
    case(9): System.out.println("Sep"); break;
    case(10): System.out.println("Oct"); break;
    case(11): System.out.println("Nov"); break;
    case(12): System.out.println("Dec"); break;
    }
    }
}
