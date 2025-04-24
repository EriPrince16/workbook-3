package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.pluralsight.Employee;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for input file and output file names
        System.out.print("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine().trim();  // Now we use the user's input for the file path

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        // Now use the inputFile path to process payroll
        processPayroll(inputFile, outputFile);

        scanner.close();
    }

    public static void processPayroll(String inputFile, String outputFile) {
        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Oops! The input file doesn't exist. Please check the file name.");
            return; // Exit the method if the file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                // Split by the pipe delimiter (|)
                String[] parts = line.split("\\|"); // Changed this to split by |

                if (parts.length == 4) {  // Assuming the file has ID, Name, HoursWorked, PayRate
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        double hoursWorked = Double.parseDouble(parts[2].trim());
                        double payRate = Double.parseDouble(parts[3].trim());

                        Employee employee = new Employee(id, name, hoursWorked, payRate);
                        double grossPay = employee.calculateGrossPay();
                        writer.write(employee.getEmployeeId() + "|" + employee.getName() + "|" + grossPay);
                        writer.newLine();
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

            System.out.println("Payroll file created successfully with " + count + " entries!");

        } catch (IOException e) {
            System.out.println("Oops! Something went wrong while processing the files.");
            e.printStackTrace();
        }
    }
}