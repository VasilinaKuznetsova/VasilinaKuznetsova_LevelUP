package ru.levelup.at.java.homework_2.task_1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.startApp();
    }

    public void startApp() {
        Scanner scan = new Scanner(System.in);
        System.out.println("CALCULATOR");
        System.out.println("Input first integer:");
        int intA;
        if (scan.hasNextInt()) {
            intA = scan.nextInt();
        } else {
            System.out.println("Error: Not an integer");
            return;
        }

        System.out.println("Input an arithmetic operation:");
        System.out.println("+ is addition,");
        System.out.println("- is subtraction,");
        System.out.println("* is multiplication");
        System.out.println("/ is division.");
        char operation = scan.next().charAt(0);


        System.out.println("Input second integer:");
        int intB;
        if (scan.hasNextInt()) {
            intB = scan.nextInt();
        } else {
            System.out.println("Error: Not an integer");
            return;
        }

        switch (operation) {
            case '+':
                System.out.print("Result = " + (intA + intB));
                break;
            case '-':
                System.out.print("Result = " + (intA - intB));
                break;
            case '*':
                System.out.print("Result = " + (intA * intB));
                break;
            case '/':
                if (intB == 0) {
                    System.out.println("Error: Divide by zero");
                } else {
                    System.out.print("Result = " + (intA / intB));
                }
                break;
            default:
                System.out.println("Error: Invalid arithmetic operation");
                break;
        }
    }
}
