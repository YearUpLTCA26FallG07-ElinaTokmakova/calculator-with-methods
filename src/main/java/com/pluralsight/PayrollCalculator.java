package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // user inputs employee's name
        System.out.print("Enter employee's name: ");
        String employeeName = myScanner.nextLine();

        // user inputs hours worked
        System.out.print("Enter hours worked: ");
        double hoursWorked = myScanner.nextDouble();

        // user inputs hourly pay rate
        System.out.print("Enter hourly pay rate: ");
        double hourlyPayRate = myScanner.nextDouble();

        // initializing values
        double regularPay = 0;
        double overtimePay = 0;
        double totalPay = 0;

        if (hoursWorked > 40) {

            // calculate how many hours should be paid overtime
            double overtimeHours = hoursWorked - 40;

            // method for first 40 hours
            regularPay = payrollRegular(employeeName, hoursWorked = 40, hourlyPayRate);

            // method for overtime pay
            overtimePay = payrollOvertime(employeeName, overtimeHours, hourlyPayRate);

            // method for total pay
            totalPay = payrollTotal(overtimePay, regularPay);
            System.out.println("The total gross pay for " + employeeName + " is $" + String.format("%.2f", totalPay));

        } else {
            // method for first 40 hours
            payrollRegular(employeeName, hoursWorked, hourlyPayRate);
        }
    }

    // method for first 40 hours
    public static double payrollRegular(String employeeName, double hoursWorked, double hourlyPayRate) {

        // formula
        double regularPay;
        regularPay = hoursWorked * hourlyPayRate;

        // output
        System.out.println("The regular gross pay for " + employeeName + " is $" + String.format("%.2f", regularPay));
        return regularPay;
    }

    // method for overtime hours
    public static double payrollOvertime(String employeeName, double overtimeHours, double hourlyPayRate) {
        hourlyPayRate = hourlyPayRate * 1.5;

        // formula for overtime pay
        double overtimePay = overtimeHours * hourlyPayRate;

        // output
        System.out.println("The overtime gross pay for " + employeeName + " is $" + String.format("%.2f", overtimePay));
        return overtimePay;
    }

    // method to add regular and overtime
    public static double payrollTotal(double overtimePay, double regularPay) {

        // sum up regular and overtime
        double totalPay = overtimePay + regularPay;

        // output
        return totalPay;
    }
}